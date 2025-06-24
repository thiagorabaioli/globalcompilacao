import java.util.ArrayList;
import java.util.List;

// Classe que representa o código de três endereços (TAC - Three Address Code)
// Esta classe permite gerar, manipular e otimizar instruções TAC
public class TAC {
    // Classe interna que representa uma instrução TAC individual
    // Cada instrução pode ter uma operação, dois argumentos e um resultado
    public static class Instruction {
        private String operation; // Operação (ex: +, -, *, /, GOTO, IF)
        private String arg1;      // Primeiro operando
        private String arg2;      // Segundo operando
        private String result;    // Resultado ou destino
        
        // Construtor para criar uma nova instrução TAC
        public Instruction(String operation, String arg1, String arg2, String result) {
            this.operation = operation;
            this.arg1 = arg1;
            this.arg2 = arg2;
            this.result = result;
        }
        
        // Métodos get para aceder aos campos da instrução
        public String getOperation() {
            return operation;
        }
        
        public String getArg1() {
            return arg1;
        }
        
        public String getArg2() {
            return arg2;
        }
        
        public String getResult() {
            return result;
        }
        
        // Converte a instrução TAC para uma representação em string
        // Formata diferentes tipos de instruções de forma apropriada
@Override
public String toString() {
    if (operation.equals("LABEL")) {
        return arg1 + ":";
    } else if (operation.equals("GOTO")) {
        return "GOTO " + result;
    } else if (operation.equals("IF")) {
        return "IF " + arg1 + " GOTO " + result;
    } else if (operation.equals("IFFALSE")) {
        return "IFFALSE " + arg1 + " GOTO " + result;
    } else if (operation.equals("PARAM")) {
        return "PARAM " + result;
    } else if (operation.equals("CALL")) {
        return result + " = CALL " + arg1;
    } else if (operation.equals("RETURN")) {
        return "RETURN " + (result != null ? result : "");
    } else if (operation.equals("ARRAY_STORE")) {
        return arg1 + "[" + arg2 + "] = " + result;
    } else if (operation.equals("ARRAY_LOAD")) {
        return result + " = " + arg1 + "[" + arg2 + "]";
    } else if (operation.isEmpty()) {
        // Simple assignment: result = arg1
        return result + " = " + arg1;
    } else if (arg2 == null) {
        return result + " = " + operation + " " + arg1;
    } else if (operation.isEmpty()) {
        return result + " = " + arg1;
    } else {
        // General case for binary operations
        return result + " = " + arg1 + " " + operation + " " + arg2;
    }
}
    }
    
    private List<Instruction> instructions; // Lista de instruções TAC
    private int tempCounter;                // Contador para variáveis temporárias
    private int labelCounter;               // Contador para etiquetas
    
    // Construtor para criar um novo objeto TAC vazio
    public TAC() {
        this.instructions = new ArrayList<>();
        this.tempCounter = 0;
        this.labelCounter = 0;
    }
    
    // Obtém a lista de instruções TAC
    public List<Instruction> getInstructions() {
        return instructions;
    }
    
    // Define a lista de instruções TAC
    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }
    
    // Gera um novo nome de variável temporária (t0, t1, t2, ...)
    public String newTemp() {
        return "t" + (tempCounter++);
    }
    
    // Gera um novo nome de etiqueta (L0, L1, L2, ...)
    public String newLabel() {
        return "L" + (labelCounter++);
    }
    
    // Métodos para adicionar diferentes tipos de instruções ao código TAC
    
    // Adiciona uma instrução aritmética (ex: +, -, *, /)
    public void addArithmetic(String op, String arg1, String arg2, String result) {
        instructions.add(new Instruction(op, arg1, arg2, result));
    }
    
    // Adiciona uma instrução de atribuição simples (a = b)
    public void addAssignment(String id, String expr) {
        instructions.add(new Instruction("", expr, null, id));
    }
    
    // Adiciona uma etiqueta (ponto de destino para saltos)
    public void addLabel(String label) {
        instructions.add(new Instruction("LABEL", label, null, null));
    }
    
    // Adiciona um salto incondicional (GOTO)
    public void addGoto(String label) {
        instructions.add(new Instruction("GOTO", null, null, label));
    }
    
    // Adiciona um salto condicional (IF condição GOTO etiqueta)
    public void addIf(String condition, String label) {
        instructions.add(new Instruction("IF", condition, null, label));
    }
    
    // Adiciona um salto condicional negativo (IFFALSE condição GOTO etiqueta)
    public void addIfFalse(String condition, String label) {
        instructions.add(new Instruction("IFFALSE", condition, null, label));
    }
    
    // Adiciona um parâmetro para chamada de função
    public void addParam(String param) {
        instructions.add(new Instruction("PARAM", null, null, param));
    }
    
    // Adiciona uma chamada de função
    public void addCall(String function, String result) {
        instructions.add(new Instruction("CALL", function, null, result));
    }
    
    // Adiciona uma instrução de retorno de função
    public void addReturn(String value) {
        instructions.add(new Instruction("RETURN", null, null, value));
    }
    
    // Adiciona uma instrução para armazenar valor num array (array[index] = value)
    public void addArrayStore(String array, String index, String value) {
        instructions.add(new Instruction("ARRAY_STORE", array, index, value));
    }
    
    // Adiciona uma instrução para carregar valor de um array (result = array[index])
    public void addArrayLoad(String array, String index, String result) {
        instructions.add(new Instruction("ARRAY_LOAD", array, index, result));
    }
    
    // Retorna o código TAC completo como uma lista de strings
    // Cada instrução é convertida para a sua representação textual
    public List<String> getCode() {
        List<String> code = new ArrayList<>();
        for (Instruction instr : instructions) {
            code.add(instr.toString());
        }
        return code;
    }
}
