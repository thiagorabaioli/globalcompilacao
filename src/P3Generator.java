import java.util.*;

public class P3Generator {
    private List<String> tacInstructions;
    private List<String> p3Instructions;
    private Set<String> variables; // Track all variables for declarations
    private Set<String> arrays;    // Track arrays for declarations
    private int tempRegisterCount;

    public P3Generator(List<String> tacInstructions) {
        this.tacInstructions = tacInstructions;
        this.p3Instructions = new ArrayList<>();
        this.variables = new HashSet<>();
        this.arrays = new HashSet<>();
        this.tempRegisterCount = 1; // R0 is always zero in P3
    }

    private String pendingLabel = null;
    public List<String> generate() {
        addInstruction("ORIG 1000h");
        for (String tac : tacInstructions) {
            String line = tac.trim();
            if (line.isEmpty()) continue;

            // Label (e.g. L0:)
            if (line.endsWith(":")) {
                pendingLabel = line;
                continue;
            }

            String[] tokens = line.split("\\s+");
            // Arithmetic assignment: t0 = x + y
            if (tokens.length == 5 && tokens[1].equals("=") && isOperator(tokens[3])) {
                handleArithmeticAssignment(tokens);
                continue;
            }

            // Simple assignment: a = b
            if (tokens.length == 3 && tokens[1].equals("=")) {
                handleSimpleAssignment(tokens);
                continue;
            }

            // IFFALSE t1 GOTO L0
            if (tokens.length == 4 && tokens[0].equals("IFFALSE")) {
                handleIfFalse(tokens);
                continue;
            }

            // RETURN x
            if (tokens.length == 2 && tokens[0].equals("RETURN")) {
                handleReturn(tokens);
                continue;
            }

            // GOTO L0
            if (tokens.length == 2 && tokens[0].equals("GOTO")) {
                handleGoto(tokens);
                continue;
            }

            // PARAM x
            if (tokens.length == 2 && tokens[0].equals("PARAM")) {
                continue;
            }

            // CALL f
            if (tokens.length == 3 && tokens[1].equals("=") && tokens[2].startsWith("CALL")) {
                continue;
            }

            // WRITE x or WRITE "string"
            if (line.contains("WRITE")) {
                handleWrite(line);
                continue;
            }

            // READ x
            if (line.contains("READ")) {
                handleRead(line);
                continue;
            }
        }

        // Add variable and array declarations at the end
        addInstruction("");
        for (String var : variables) {
            if (isValidIdentifier(var))
                addInstruction(var + ": WORD 0");
        }
        for (String arr : arrays) {
            if (isValidIdentifier(arr))
                addInstruction(arr + ": TAB 10"); // Default size, adjust as needed
        }

        return p3Instructions;
    }

    private void addInstruction(String instr) {
        if (pendingLabel != null) {
            p3Instructions.add(pendingLabel + " " + instr);
            pendingLabel = null;
        } else {
            p3Instructions.add(instr);
        }
    }

    // Helper for correct array access syntax (no M[arr+N], always use register for offset)
    private void addArrayAccess(String arr, String idx, String reg, boolean isStore) {
        if (isImmediate(idx)) {
            int offset = Integer.parseInt(idx);
            if (offset == 0) {
                if (isStore) {
                    addInstruction(String.format("MOV M[%s], %s", arr, reg));
                } else {
                    addInstruction(String.format("MOV %s, M[%s]", reg, arr));
                }
            } else {
                String addrReg = "R7";
                addInstruction(String.format("MOV %s, %s", addrReg, arr));
                addInstruction(String.format("ADD %s, %d", addrReg, offset));
                if (isStore) {
                    addInstruction(String.format("MOV M[%s], %s", addrReg, reg));
                } else {
                    addInstruction(String.format("MOV %s, M[%s]", reg, addrReg));
                }
            }
        } else {
            String addrReg = "R7";
            addInstruction(String.format("MOV %s, %s", addrReg, arr));
            addInstruction(String.format("ADD %s, %s", addrReg, idx));
            if (isStore) {
                addInstruction(String.format("MOV M[%s], %s", addrReg, reg));
            } else {
                addInstruction(String.format("MOV %s, M[%s]", reg, addrReg));
            }
        }
    }

    private void handleArithmeticAssignment(String[] tokens) {
        // Format: t0 = x + y
        String dest = tokens[0];
        String left = tokens[2];
        String op = tokens[3];
        String right = tokens[4];

        // Use R1 and R2 for operands, R3 for result
        String regLeft = "R1";
        String regRight = "R2";
        String regDest = "R3";

        // Load left operand
        if (isImmediate(left)) {
            addInstruction(String.format("MOV %s, %s", regLeft, left));
        } else if (isArrayAccess(left)) {
            String[] arr = parseArrayAccess(left);
            arrays.add(arr[0]);
            addArrayAccess(arr[0], arr[1], regLeft, false);
        } else if (isValidIdentifier(left)) {
            variables.add(left);
            addInstruction(String.format("MOV %s, M[%s]", regLeft, left));
        }

        // Load right operand
        if (isImmediate(right)) {
            addInstruction(String.format("MOV %s, %s", regRight, right));
        } else if (isArrayAccess(right)) {
            String[] arr = parseArrayAccess(right);
            arrays.add(arr[0]);
            addArrayAccess(arr[0], arr[1], regRight, false);
        } else if (isValidIdentifier(right)) {
            variables.add(right);
            addInstruction(String.format("MOV %s, M[%s]", regRight, right));
        }

        String p3Op = getP3Op(op);
        addInstruction(String.format("%s %s, %s", p3Op, regLeft, regRight));
        addInstruction(String.format("MOV %s, %s", regDest, regLeft));

        // Store result
        if (isArrayAccess(dest)) {
            String[] arr = parseArrayAccess(dest);
            arrays.add(arr[0]);
            addArrayAccess(arr[0], arr[1], regDest, true);
        } else if (isValidIdentifier(dest)) {
            variables.add(dest);
            addInstruction(String.format("MOV M[%s], %s", dest, regDest));
        }
    }

    private void handleSimpleAssignment(String[] tokens) {
        // Format: a = b
        String dest = tokens[0];
        String src = tokens[2];
        String regDest = "R1";

        // Load src
        if (isImmediate(src)) {
            addInstruction(String.format("MOV %s, %s", regDest, src));
        } else if (isArrayAccess(src)) {
            String[] arr = parseArrayAccess(src);
            arrays.add(arr[0]);
            addArrayAccess(arr[0], arr[1], regDest, false);
        } else if (isValidIdentifier(src)) {
            variables.add(src);
            addInstruction(String.format("MOV %s, M[%s]", regDest, src));
        }

        // Store to dest
        if (isArrayAccess(dest)) {
            String[] arr = parseArrayAccess(dest);
            arrays.add(arr[0]);
            addArrayAccess(arr[0], arr[1], regDest, true);
        } else if (isValidIdentifier(dest)) {
            variables.add(dest);
            addInstruction(String.format("MOV M[%s], %s", dest, regDest));
        }
    }

    private void handleIfFalse(String[] tokens) {
        // Format: IFFALSE t1 GOTO L0
        String condVar = tokens[1];
        String label = tokens[3];
        String regCond = "R1";
        if (isValidIdentifier(condVar)) variables.add(condVar);
        addInstruction(String.format("MOV %s, M[%s]", regCond, condVar));
        addInstruction(String.format("CMP %s, 0", regCond));
        addInstruction(String.format("JMP.Z %s", label));
    }

    private void handleReturn(String[] tokens) {
        // Format: RETURN x
        String src = tokens[1];
        String regSrc = "R1";
        if (isImmediate(src)) {
            addInstruction(String.format("MOV %s, %s", regSrc, src));
        } else if (isArrayAccess(src)) {
            String[] arr = parseArrayAccess(src);
            arrays.add(arr[0]);
            addArrayAccess(arr[0], arr[1], regSrc, false);
        } else if (isValidIdentifier(src)) {
            variables.add(src);
            addInstruction(String.format("MOV %s, M[%s]", regSrc, src));
        }
        addInstruction("RET");
    }

    private void handleGoto(String[] tokens) {
        // Format: GOTO label
        String label = tokens[1];
        addInstruction(String.format("JMP %s", label));
    }

    private void handleWrite(String line) {
        // WRITE x or WRITE "string"
        String[] parts = line.split("WRITE");
        String arg = parts[1].trim();
        if (arg.startsWith("\"")) {
            // String literal: store in memory and output char by char (not implemented here)
            return;
        } else {
            String reg = "R1";
            if (isImmediate(arg)) {
                addInstruction(String.format("MOV %s, %s", reg, arg));
            } else if (isArrayAccess(arg)) {
                String[] arr = parseArrayAccess(arg);
                arrays.add(arr[0]);
                addArrayAccess(arr[0], arr[1], reg, false);
            } else if (isValidIdentifier(arg)) {
                variables.add(arg);
                addInstruction(String.format("MOV %s, M[%s]", reg, arg));
            }
            addInstruction(String.format("MOV M[FFFEh], %s", reg));
        }
    }

    private void handleRead(String line) {
        // READ x
        String[] parts = line.split("READ");
        String arg = parts[1].trim();
        String reg = "R1";
        addInstruction(String.format("MOV %s, M[FFFFh]", reg));
        if (isArrayAccess(arg)) {
            String[] arr = parseArrayAccess(arg);
            arrays.add(arr[0]);
            addArrayAccess(arr[0], arr[1], reg, true);
        } else if (isValidIdentifier(arg)) {
            variables.add(arg);
            addInstruction(String.format("MOV M[%s], %s", arg, reg));
        }
    }

    private boolean isImmediate(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    private String getP3Op(String op) {
        switch (op) {
            case "+": return "ADD";
            case "-": return "SUB";
            case "*": return "MUL";
            case "/": return "DIV";
            default: return "NOP";
        }
    }

    // Array access detection: e.g. numeros[3]
    private boolean isArrayAccess(String s) {
        return s.contains("[") && s.contains("]");
    }

    // Returns [arrayName, index]
    private String[] parseArrayAccess(String s) {
        int l = s.indexOf('[');
        int r = s.indexOf(']');
        String arr = s.substring(0, l);
        String idx = s.substring(l + 1, r);
        return new String[]{arr, idx};
    }

    // Valid identifier for P3 (no numbers at start, no dot, etc.)
    private boolean isValidIdentifier(String s) {
        return s.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }
}