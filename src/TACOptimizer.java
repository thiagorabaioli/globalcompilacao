import java.util.*;

// Classe TACOptimizer - Implementa técnicas de otimização para o código de três endereços (TAC)
public class TACOptimizer {
    private List<TAC.Instruction> originalInstructions;  // Lista das instruções originais

    // Construtor que inicializa o otimizador com uma cópia das instruções TAC
    // @param tac O código TAC a ser otimizado
    public TACOptimizer(TAC tac) {
        this.originalInstructions = new ArrayList<>();
        // Clona as instruções para evitar modificar o código original
        for (int i = 0; i < tac.getInstructions().size(); i++) {
            TAC.Instruction original = tac.getInstructions().get(i);
            this.originalInstructions.add(new TAC.Instruction(
                original.getOperation(), 
                original.getArg1(), 
                original.getArg2(), 
                original.getResult()
            ));
        }
    }

    // Aplica otimizações ao código TAC
    // @return Um novo objeto TAC com instruções otimizadas
    public TAC optimize() {
        TAC optimizedTAC = new TAC();
        
        // Cria uma cópia de trabalho das instruções originais
        List<TAC.Instruction> instructions = new ArrayList<>();
        for (TAC.Instruction instr : originalInstructions) {
            instructions.add(new TAC.Instruction(
                instr.getOperation(),
                instr.getArg1(),
                instr.getArg2(),
                instr.getResult()
            ));
        }
        
        optimizedTAC.setInstructions(instructions);
        
        // Aplica otimizações até que não seja possível fazer mais alterações
        boolean changed;
        do {
            changed = false;
            
            // Aplica primeiro o constant folding (avaliação de constantes)
            changed |= performConstantFolding(optimizedTAC);
            
            // Depois aplica a propagação de cópias
            changed |= performSafeCopyPropagation(optimizedTAC);
            
            // Aplica eliminação de subexpressões comuns
            changed |= performCommonSubexpressionElimination(optimizedTAC);
            
            // Aplica eliminação de atribuições redundantes
            changed |= performRedundantAssignmentElimination(optimizedTAC);
            
            // Finalmente, aplica eliminação de código morto
            changed |= performDeadCodeElimination(optimizedTAC);
            
        } while (changed);
        
        return optimizedTAC;
    }

    // Constant folding: otimiza operações aritméticas com constantes literais
    // Substitui expressões como "t0 = 2 + 3" por "t0 = 5"
    private boolean performConstantFolding(TAC optimizedTAC) {
        boolean changed = false;
        List<TAC.Instruction> instructions = optimizedTAC.getInstructions();
        
        for (int i = 0; i < instructions.size(); i++) {
            TAC.Instruction instr = instructions.get(i);
            
            // Apenas avalia operações com duas constantes literais
            if (isArithmeticOp(instr.getOperation()) && 
                instr.getArg1() != null && 
                instr.getArg2() != null && 
                isConstant(instr.getArg1()) && 
                isConstant(instr.getArg2())) {
                
                String result = evaluateConstantExpression(
                    instr.getOperation(), 
                    instr.getArg1(), 
                    instr.getArg2()
                );
                
                if (result != null) {
                    // Usa string vazia para operação para evitar sinais de igual duplicados
                    instructions.set(i, new TAC.Instruction(
                        "", result, null, instr.getResult()
                    ));
                    changed = true;
                }
            }
        }
        
        return changed;
    }

    // Propagação de cópias segura que substitui variáveis dentro dos limites de funções
    // Por exemplo, se temos "a = b" e depois "c = a + d", substitui por "c = b + d"
    private boolean performSafeCopyPropagation(TAC optimizedTAC) {
        boolean changed = false;
        List<TAC.Instruction> instructions = optimizedTAC.getInstructions();
        
        // Rastreia cópias dentro de cada função
        Map<String, Map<String, String>> functionCopies = new HashMap<>();
        String currentFunction = "global";
        
        // Primeiro, identifica todas as funções
        for (int i = 0; i < instructions.size(); i++) {
            TAC.Instruction instr = instructions.get(i);
            
            // Rastreia os limites de funções
            if (instr.getOperation().equals("LABEL")) {
                String label = instr.getArg1();
                if (label.endsWith("_start")) {
                    currentFunction = label.replace("_start", "");
                    functionCopies.put(currentFunction, new HashMap<>());
                } else if (label.endsWith("_end")) {
                    currentFunction = "global";
                }
            }
        }
        
        // Reinicia para a propagação real
        currentFunction = "global";
        
        // Agora propaga cópias dentro de cada função
        for (int i = 0; i < instructions.size(); i++) {
            TAC.Instruction instr = instructions.get(i);
            
            // Rastreia os limites de funções
            if (instr.getOperation().equals("LABEL")) {
                String label = instr.getArg1();
                if (label.endsWith("_start")) {
                    currentFunction = label.replace("_start", "");
                } else if (label.endsWith("_end")) {
                    currentFunction = "global";
                }
                
                // Limpa todas as cópias nos limites de funções
                if (!functionCopies.containsKey(currentFunction)) {
                    functionCopies.put(currentFunction, new HashMap<>());
                } else {
                    functionCopies.get(currentFunction).clear();
                }
            }
            
            // Rastreia atribuições do tipo "x = y"
            if (instr.getOperation().equals("=") && 
                instr.getArg2() == null && 
                instr.getArg1() != null && 
                !isConstant(instr.getArg1())) {
                
                // Regista esta cópia
                Map<String, String> copies = functionCopies.get(currentFunction);
                copies.put(instr.getResult(), instr.getArg1());
            } 
            // Para outras operações, tenta propagar cópias
            else if (instr.getArg1() != null || instr.getArg2() != null) {
                Map<String, String> copies = functionCopies.get(currentFunction);
                String arg1 = instr.getArg1();
                String arg2 = instr.getArg2();
                boolean modified = false;
                
                // Tenta substituir arg1 se for uma cópia
                if (arg1 != null && copies.containsKey(arg1)) {
                    arg1 = copies.get(arg1);
                    modified = true;
                }
                
                // Tenta substituir arg2 se for uma cópia
                if (arg2 != null && copies.containsKey(arg2)) {
                    arg2 = copies.get(arg2);
                    modified = true;
                }
                
                // Atualiza a instrução se fizemos alterações
                if (modified) {
                    instructions.set(i, new TAC.Instruction(
                        instr.getOperation(),
                        arg1,
                        arg2,
                        instr.getResult()
                    ));
                    changed = true;
                }
            }
            
            // Limpa cópias após chamadas de funções, pois podem modificar variáveis
            if (instr.getOperation().equals("CALL")) {
                functionCopies.get(currentFunction).clear();
            }
        }
        
        return changed;
    }

    /**
     * Eliminação de Subexpressões Comuns: Identifica e elimina computações repetidas
     * dentro do mesmo escopo de função
     */
    private boolean performCommonSubexpressionElimination(TAC optimizedTAC) {
        boolean changed = false;
        List<TAC.Instruction> instructions = optimizedTAC.getInstructions();
        
        // Each function gets its own expression mapping
        Map<String, Map<String, String>> functionExpressions = new HashMap<>();
        String currentFunction = "global";
        
        // First identify all functions
        for (int i = 0; i < instructions.size(); i++) {
            TAC.Instruction instr = instructions.get(i);
            
            // Track function boundaries
            if (instr.getOperation().equals("LABEL")) {
                String label = instr.getArg1();
                if (label.endsWith("_start")) {
                    currentFunction = label.replace("_start", "");
                    functionExpressions.put(currentFunction, new HashMap<>());
                } else if (label.endsWith("_end")) {
                    currentFunction = "global";
                }
            }
        }
        
        // Reset for the actual CSE pass
        currentFunction = "global";
        
        // Now perform CSE within each function
        for (int i = 0; i < instructions.size(); i++) {
            TAC.Instruction instr = instructions.get(i);
            
            // Track function boundaries
            if (instr.getOperation().equals("LABEL")) {
                String label = instr.getArg1();
                if (label.endsWith("_start")) {
                    currentFunction = label.replace("_start", "");
                } else if (label.endsWith("_end")) {
                    currentFunction = "global";
                }
                continue;
            }
            
            // Clear expressions at control flow points
            if (instr.getOperation().equals("GOTO") || 
                instr.getOperation().equals("IF") || 
                instr.getOperation().equals("IFFALSE") ||
                instr.getOperation().equals("CALL")) {
                
                // Clear all expressions in this function as they might not be valid after control flow
                if (functionExpressions.containsKey(currentFunction)) {
                    functionExpressions.get(currentFunction).clear();
                }
                continue;
            }
            
            // Only consider binary arithmetic/logical operations
            if (isArithmeticOp(instr.getOperation()) && 
                instr.getArg1() != null && 
                instr.getArg2() != null) {
                
                // Create a key for this expression
                String exprKey = instr.getOperation() + ":" + instr.getArg1() + ":" + instr.getArg2();
                
                // Get or create expression map for this function
                Map<String, String> exprMap = functionExpressions.computeIfAbsent(
                    currentFunction, k -> new HashMap<>());
                
                // Check if we've seen this expression before in this function
                if (exprMap.containsKey(exprKey)) {
                    String previousResult = exprMap.get(exprKey);
                    
                    // Replace the computation with a copy of the previous result, using empty operation
                    instructions.set(i, new TAC.Instruction(
                        "", previousResult, null, instr.getResult()
                    ));
                    changed = true;
                } else {
                    // Record this new expression and its result
                    exprMap.put(exprKey, instr.getResult());
                }
            }
        }
        
        return changed;
    }

    /**
     * Elimina atribuições redundantes (variáveis que são imediatamente sobrescritas)
     */
    private boolean performRedundantAssignmentElimination(TAC optimizedTAC) {
        boolean changed = false;
        List<TAC.Instruction> instructions = optimizedTAC.getInstructions();
        List<Integer> toRemove = new ArrayList<>();
        
        // Track function boundaries for safety
        String currentFunction = "global";
        
        // Find redundant assignments
        for (int i = 0; i < instructions.size() - 1; i++) {
            TAC.Instruction instr = instructions.get(i);
            
            // Track function boundaries
            if (instr.getOperation().equals("LABEL")) {
                String label = instr.getArg1();
                if (label.endsWith("_start")) {
                    currentFunction = label.replace("_start", "");
                } else if (label.endsWith("_end")) {
                    currentFunction = "global";
                }
                continue;
            }
            
            // Skip non-assignment operations
            if (!instr.getOperation().equals("=") || instr.getResult() == null) {
                continue;
            }
            
            // Skip global variables for safety
            if (currentFunction.equals("global")) {
                continue;
            }
            
            // Check the next instruction
            TAC.Instruction next = instructions.get(i + 1);
            
            // If next instruction reassigns the same variable
            if (next.getOperation().equals("=") && 
                next.getResult() != null && 
                next.getResult().equals(instr.getResult())) {
                
                // Add this instruction to the remove list
                toRemove.add(i);
                changed = true;
            }
        }
        
        // Remove instructions in reverse order to maintain indices
        Collections.sort(toRemove, Collections.reverseOrder());
        for (int index : toRemove) {
            instructions.remove(index);
        }
        
        return changed;
    }

    /**
     * Eliminação de Código Morto: Remove atribuições a variáveis que provavelmente nunca são usadas
     */
    private boolean performDeadCodeElimination(TAC optimizedTAC) {
        boolean changed = false;
        List<TAC.Instruction> instructions = optimizedTAC.getInstructions();
        
        // Track variable definitions and uses per function
        Map<String, Set<String>> functionDefinedVars = new HashMap<>();
        Map<String, Set<String>> functionUsedVars = new HashMap<>();
        
        String currentFunction = "global";
        
        // First pass: identify all variable uses
        for (int i = 0; i < instructions.size(); i++) {
            TAC.Instruction instr = instructions.get(i);
            
            // Track function boundaries
            if (instr.getOperation().equals("LABEL")) {
                String label = instr.getArg1();
                if (label.endsWith("_start")) {
                    currentFunction = label.replace("_start", "");
                    functionDefinedVars.put(currentFunction, new HashSet<>());
                    functionUsedVars.put(currentFunction, new HashSet<>());
                } else if (label.endsWith("_end")) {
                    currentFunction = "global";
                }
                continue;
            }
            
            // Record variable uses in arguments
            if (instr.getArg1() != null && !isConstant(instr.getArg1())) {
                functionUsedVars.computeIfAbsent(currentFunction, k -> new HashSet<>())
                               .add(instr.getArg1());
            }
            
            if (instr.getArg2() != null && !isConstant(instr.getArg2())) {
                functionUsedVars.computeIfAbsent(currentFunction, k -> new HashSet<>())
                               .add(instr.getArg2());
            }
            
            // Special cases for parameter passing and WRITE
            if (instr.getOperation().equals("PARAM") || 
                instr.getOperation().equals("WRITE") || 
                instr.getOperation().equals("RETURN")) {
                
                if (instr.getResult() != null && !isConstant(instr.getResult())) {
                    functionUsedVars.computeIfAbsent(currentFunction, k -> new HashSet<>())
                                   .add(instr.getResult());
                }
            }
            
            // Record variable definitions
            if (isAssignment(instr.getOperation()) && instr.getResult() != null) {
                functionDefinedVars.computeIfAbsent(currentFunction, k -> new HashSet<>())
                                  .add(instr.getResult());
            }
        }
        
        // Second pass: remove dead assignments
        List<Integer> toRemove = new ArrayList<>();
        currentFunction = "global";
        
        for (int i = 0; i < instructions.size(); i++) {
            TAC.Instruction instr = instructions.get(i);
            
            // Track function boundaries
            if (instr.getOperation().equals("LABEL")) {
                String label = instr.getArg1();
                if (label.endsWith("_start")) {
                    currentFunction = label.replace("_start", "");
                } else if (label.endsWith("_end")) {
                    currentFunction = "global";
                }
                continue;
            }
            
            // Skip instructions that aren't simple assignments
            if (!isAssignment(instr.getOperation()) || instr.getResult() == null) {
                continue;
            }
            
            // Skip instructions with side effects
            if (hasSpecialEffects(instr)) {
                continue;
            }
            
            // Skip if the variable is used
            if (functionUsedVars.getOrDefault(currentFunction, Collections.emptySet())
                               .contains(instr.getResult())) {
                continue;
            }
            
            // Skip temporaries that might be used indirectly
            if (instr.getResult().startsWith("t")) {
                continue;
            }
            
            // If we got here, this is an assignment to a variable that is never used
            toRemove.add(i);
            changed = true;
        }
        
        // Remove dead code in reverse order to preserve indices
        Collections.sort(toRemove, Collections.reverseOrder());
        for (int index : toRemove) {
            instructions.remove(index);
        }
        
        return changed;
    }
    
    /**
     * Verifica se uma instrução tem efeitos especiais que devem impedir sua remoção
     */
    private boolean hasSpecialEffects(TAC.Instruction instr) {
        // Function calls, I/O, control flow, etc. have side effects
        return instr.getOperation().equals("CALL") ||
               instr.getOperation().equals("PARAM") ||
               instr.getOperation().equals("RETURN") ||
               instr.getOperation().equals("WRITE") ||
               instr.getOperation().equals("WRITES") ||
               instr.getOperation().equals("READ") ||
               instr.getOperation().equals("READS") ||
               instr.getOperation().equals("GOTO") ||
               instr.getOperation().equals("IF") ||
               instr.getOperation().equals("IFFALSE") ||
               instr.getOperation().equals("ARRAY_STORE");
    }
    
    // Helper methods
    
    private boolean isArithmeticOp(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || 
               op.equals("/") || op.equals("%") || op.equals("<") || 
               op.equals("<=") || op.equals(">") || op.equals(">=") || 
               op.equals("==") || op.equals("!=") || op.equals("&&") || 
               op.equals("||") || op.equals("!");
    }
    
    private boolean isAssignment(String op) {
        return op.equals("=") || isArithmeticOp(op);
    }
    
    private boolean isConstant(String value) {
        if (value == null) return false;
        
        // Check if it's a numeric literal
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            // Not a numeric literal
        }
        
        // Check if it's a string literal (surrounded by quotes)
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return true;
        }
        
        return false;
    }
    
    private String evaluateConstantExpression(String op, String arg1, String arg2) {
        try {
            // Parse numeric values
            double num1 = Double.parseDouble(arg1);
            double num2 = arg2 != null ? Double.parseDouble(arg2) : 0;
            
            double result;
            switch (op) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
                case "%": result = num1 % num2; break;
                case "<": return num1 < num2 ? "1" : "0";
                case "<=": return num1 <= num2 ? "1" : "0";
                case ">": return num1 > num2 ? "1" : "0";
                case ">=": return num1 >= num2 ? "1" : "0";
                case "==": return num1 == num2 ? "1" : "0";
                case "!=": return num1 != num2 ? "1" : "0";
                case "!": return num1 == 0 ? "1" : "0";
                default: return null;
            }
            
            // Check if result is an integer
            if (result == (int)result) {
                return Integer.toString((int)result);
            } else {
                return Double.toString(result);
            }
        } catch (NumberFormatException e) {
            // Not numeric constants
            return null;
        }
    }
} 