import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// Classe responsável por gerar código TAC (Three-Address Code) diretamente a partir
// da árvore sintática abstrata da linguagem MOC.
// Esta classe implementa o padrão Visitor e percorre a AST, emitindo código TAC.
public class MOCTACGenerator extends MOCBaseVisitor<TACResult> {
    
    private List<String> tacCode;        // Lista que armazena o código TAC gerado
    private int tempCounter;             // Contador para variáveis temporárias
    private int labelCounter;            // Contador para etiquetas (labels)
    private Map<String, String> symbolTable;  // Tabela de símbolos para rastrear variáveis
    private Stack<String> scopeStack;    // Stack para controlar o scope atual
    
    // Construtor do gerador TAC
    public MOCTACGenerator() {
        this.tacCode = new ArrayList<>();
        this.tempCounter = 0;
        this.labelCounter = 0;
        this.symbolTable = new HashMap<>();
        this.scopeStack = new Stack<>();
    }
    

    // Gera um novo nome de variável temporária
    private String newTemp() {
        return "t" + (tempCounter++);
    }
    
    // Gera um novo nome de etiqueta
    private String newLabel() {
        return "L" + (labelCounter++);
    }
    
    // Adiciona uma linha de código TAC à lista de código
    private void emit(String code) {
        tacCode.add(code);
    }
    
    // Obtém todo o código TAC gerado
    public List<String> getCode() {
        return tacCode;
    }
    
    // Visita o nó raiz do programa
    @Override
    public TACResult visitStart(MOCParser.StartContext ctx) {
        // Visita todos os filhos (protótipos, funções e declarações de variáveis)
        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            visit(ctx.getChild(i));
        }
        
        // Visita explicitamente a função main
        return visit(ctx.mainFunction());
    }
    
    // Visita declarações de funções
    @Override
    public TACResult visitFunctionDecl(MOCParser.FunctionDeclContext ctx) {
        String functionName = ctx.ID().getText();
        emit("FUNCTION " + functionName + " :");
        
        // Empurra o nome da função atual no scopeStack
        scopeStack.push(functionName);
        
        // Processa os parâmetros
        if (ctx.paramList() != null) {
            visit(ctx.paramList());
        }
        
        // Visita o bloco da função
        visit(ctx.block());
        
        // Adiciona um retorno implícito se a função for void
        if (ctx.type().getText().equals("void") && !tacCode.get(tacCode.size() - 1).startsWith("RETURN")) {
            emit("RETURN");
        }
        
        // Pop do scope da função atual
        scopeStack.pop();
        
        emit("END FUNCTION " + functionName);
        
        return new TACResult();
    }
    
    // Visita a função main
    @Override
    public TACResult visitMainFunction(MOCParser.MainFunctionContext ctx) {
        emit("FUNCTION main :");
        
        // Empurra o nome da função atual no scopeStack
        scopeStack.push("main");
        
        // Visita o bloco da função main
        visit(ctx.block());
        
        // Adiciona um retorno implícito para main
        emit("RETURN");
        
        // Pop do scope da função main
        scopeStack.pop();
        
        emit("END FUNCTION main");
        
        return new TACResult();
    }
    
    // Visita a lista de parâmetros de uma função
    @Override
    public TACResult visitParamList(MOCParser.ParamListContext ctx) {
        // Processa cada parâmetro
        for (MOCParser.ParamContext param : ctx.param()) {
            visit(param);
        }
        return new TACResult();
    }
    
    // Visita um parâmetro individual de função
    @Override
    public TACResult visitParam(MOCParser.ParamContext ctx) {
        // Se o parâmetro tem um identificador
        if (ctx.ID() != null) {
            String paramName = ctx.ID().getText();
            String paramType = ctx.type().getText();
            
            // Verifica se é um array
            boolean isArray = ctx.LBRACK() != null;
            
            // Registra o parâmetro na tabela de símbolos
            String fullName = scopeStack.peek() + "." + paramName;
            symbolTable.put(fullName, paramType + (isArray ? "[]" : ""));
            
            emit("PARAM " + paramType + (isArray ? "[]" : "") + " " + paramName);
        }
        return new TACResult();
    }
    
    // Visita um bloco de código
    @Override
    public TACResult visitBlock(MOCParser.BlockContext ctx) {
        // Visita todos os statements dentro do bloco
        for (MOCParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        return new TACResult();
    }
    
    // Visita declarações de variáveis
    @Override
    public TACResult visitVarDecl(MOCParser.VarDeclContext ctx) {
        String type = ctx.type().getText();
        
        // Processa declarações simples
        if (ctx.simpleDeclList() != null) {
            visit(ctx.simpleDeclList());
        }
        
        // Processa declarações de arrays
        if (ctx.arrayDeclList() != null) {
            visit(ctx.arrayDeclList());
        }
        
        return new TACResult();
    }
    
    // Visita uma lista de declarações de variáveis simples
    @Override
    public TACResult visitSimpleDeclList(MOCParser.SimpleDeclListContext ctx) {
        // Visita cada declaração simples
        for (MOCParser.SimpleDeclContext simpleDecl : ctx.simpleDecl()) {
            visit(simpleDecl);
        }
        return new TACResult();
    }
    
    // Visita uma declaração de variável simples
    @Override
    public TACResult visitSimpleDecl(MOCParser.SimpleDeclContext ctx) {
        String id = ctx.ID().getText();
        String currentScope = scopeStack.isEmpty() ? "global" : scopeStack.peek();
        String fullName = currentScope + "." + id;
        
        // Registra a variável na tabela de símbolos
        // O tipo será recuperado do contexto pai (visitVarDecl)
        String type = ((MOCParser.VarDeclContext)ctx.getParent().getParent()).type().getText();
        symbolTable.put(fullName, type);
        
        emit("DECLARE " + type + " " + id);
        
        // Se houver inicialização
        if (ctx.initValue() != null) {
            TACResult initResult = visit(ctx.initValue());
            emit(id + " = " + initResult.place);
        }
        
        return new TACResult();
    }
    
    // Visita uma lista de declarações de arrays
    @Override
    public TACResult visitArrayDeclList(MOCParser.ArrayDeclListContext ctx) {
        // Visita cada declaração de array
        for (MOCParser.ArrayDeclContext arrayDecl : ctx.arrayDecl()) {
            visit(arrayDecl);
        }
        return new TACResult();
    }
    
    // Visita uma declaração de array
    @Override
    public TACResult visitArrayDecl(MOCParser.ArrayDeclContext ctx) {
        String id = ctx.ID().getText();
        String currentScope = scopeStack.isEmpty() ? "global" : scopeStack.peek();
        String fullName = currentScope + "." + id;
        
        // Registra o array na tabela de símbolos
        String type = ((MOCParser.VarDeclContext)ctx.getParent().getParent()).type().getText();
        
        TACResult arraySuffixResult = visit(ctx.arraySuffix());
        symbolTable.put(fullName, type + "[]");
        
        String size = arraySuffixResult.size;
        emit("DECLARE_ARRAY " + type + "[] " + id + " " + size);
        
        // Se houver inicialização
        if (ctx.initValue() != null) {
            TACResult initResult = visit(ctx.initValue());
            // Para inicialização de array, pode ser necessário um loop ou código específico
            // dependendo se é uma lista de valores ou um único valor
            if (initResult.isArrayInit) {
                // Código para inicialização com lista de valores
                // ...
            } else {
                // Código para inicialização com um único valor
                // ...
            }
        }
        
        return new TACResult();
    }
    
    @Override
    public TACResult visitArraySuffix(MOCParser.ArraySuffixContext ctx) {
        TACResult result = new TACResult();
        
        // Se o tamanho for explícito
        if (ctx.INT_LITERAL() != null) {
            result.size = ctx.INT_LITERAL().getText();
        } else {
            // Tamanho deduzido (será determinado pela inicialização)
            result.size = null;
        }
        
        return result;
    }
    
    @Override
    public TACResult visitInitValue(MOCParser.InitValueContext ctx) {
        TACResult result = new TACResult();
        
        // Se for uma expressão simples
        if (ctx.expr() != null) {
            result = visit(ctx.expr());
        }
        // Se for uma função de input
        else if (ctx.inputFunction() != null) {
            result = visit(ctx.inputFunction());
        }
        // Se for uma lista de expressões (inicialização de array)
        else if (ctx.exprList() != null) {
            result.isArrayInit = true;
            result = visit(ctx.exprList());
        }
        
        return result;
    }
    
    @Override
    public TACResult visitExprList(MOCParser.ExprListContext ctx) {
        TACResult result = new TACResult();
        List<String> places = new ArrayList<>();
        
        // Visita cada expressão na lista
        for (MOCParser.ExprContext expr : ctx.expr()) {
            TACResult exprResult = visit(expr);
            places.add(exprResult.place);
        }
        
        result.places = places;
        result.size = String.valueOf(places.size());
        
        return result;
    }
    
    @Override
    public TACResult visitInputFunction(MOCParser.InputFunctionContext ctx) {
        TACResult result = new TACResult();
        result.place = newTemp();
        
        if (ctx.READ() != null) {
            emit(result.place + " = READ()");
        } else if (ctx.READC() != null) {
            emit(result.place + " = READC()");
        } else if (ctx.READS() != null) {
            emit(result.place + " = READS()");
        }
        
        return result;
    }
    
    @Override
    public TACResult visitAssignment(MOCParser.AssignmentContext ctx) {
        // Se for atribuição simples
        if (ctx.LBRACK() == null) {
            String id = ctx.ID().getText();
            TACResult exprResult = visit(ctx.expr(0));
            
            emit(id + " = " + exprResult.place);
            
            TACResult result = new TACResult();
            result.place = id;
            return result;
        }
        // Se for atribuição a um elemento de array
        else {
            String id = ctx.ID().getText();
            TACResult indexResult = visit(ctx.expr(0));
            TACResult valueResult = visit(ctx.expr(1));
            
            emit(id + "[" + indexResult.place + "] = " + valueResult.place);
            
            TACResult result = new TACResult();
            result.place = id + "[" + indexResult.place + "]";
            return result;
        }
    }
    
    @Override
    public TACResult visitExpr(MOCParser.ExprContext ctx) {
        TACResult result = new TACResult();
        
        // Expressão binária
        if (ctx.getChildCount() == 3 && (ctx.PLUS() != null || ctx.MINUS() != null || 
                                        ctx.MULT() != null || ctx.DIV() != null || ctx.MOD() != null)) {
            
            TACResult left = visit(ctx.expr(0));
            TACResult right = visit(ctx.expr(1));
            
            String op = "";
            if (ctx.PLUS() != null) op = "+";
            else if (ctx.MINUS() != null) op = "-";
            else if (ctx.MULT() != null) op = "*";
            else if (ctx.DIV() != null) op = "/";
            else if (ctx.MOD() != null) op = "%";
            
            result.place = newTemp();
            emit(result.place + " = " + left.place + " " + op + " " + right.place);
        }
        // Expressão entre parênteses
        else if (ctx.LPAREN() != null && ctx.RPAREN() != null && ctx.casting() == null) {
            result = visit(ctx.expr(0));
        }
        // Chamada de função
        else if (ctx.functionCall() != null) {
            result = visit(ctx.functionCall());
        }
        // Casting
        else if (ctx.casting() != null) {
            result = visit(ctx.casting());
        }
        // Função de input
        else if (ctx.inputFunction() != null) {
            result = visit(ctx.inputFunction());
        }
        // Acesso a elemento de array
        else if (ctx.LBRACK() != null) {
            String id = ctx.ID().getText();
            TACResult indexResult = visit(ctx.expr(0));
            
            result.place = newTemp();
            emit(result.place + " = " + id + "[" + indexResult.place + "]");
        }
        // Identificador
        else if (ctx.ID() != null) {
            result.place = ctx.ID().getText();
        }
        // Literal inteiro
        else if (ctx.INT_LITERAL() != null) {
            result.place = ctx.INT_LITERAL().getText();
        }
        // Literal double
        else if (ctx.DOUBLE_LITERAL() != null) {
            result.place = ctx.DOUBLE_LITERAL().getText();
        }
        // Literal string
        else if (ctx.STRING_LITERAL() != null) {
            result.place = ctx.STRING_LITERAL().getText();
        }
        
        return result;
    }
    
    @Override
    public TACResult visitFunctionCall(MOCParser.FunctionCallContext ctx) {
        String functionName = ctx.ID().getText();
        List<String> argPlaces = new ArrayList<>();
        
        // Processa os argumentos da chamada
        if (ctx.expr() != null && !ctx.expr().isEmpty()) {
            for (MOCParser.ExprContext expr : ctx.expr()) {
                TACResult exprResult = visit(expr);
                argPlaces.add(exprResult.place);
                emit("PARAM " + exprResult.place);
            }
        }
        
        TACResult result = new TACResult();
        result.place = newTemp();
        
        emit(result.place + " = CALL " + functionName + ", " + argPlaces.size());
        
        return result;
    }
    
    @Override
    public TACResult visitCasting(MOCParser.CastingContext ctx) {
        String type = ctx.type().getText();
        TACResult exprResult = visit(ctx.expr());
        
        TACResult result = new TACResult();
        result.place = newTemp();
        
        emit(result.place + " = (" + type + ") " + exprResult.place);
        
        return result;
    }
    
    @Override
    public TACResult visitCondition(MOCParser.ConditionContext ctx) {
        TACResult result = new TACResult();
        
        // Expressão com operador relacional
        if (ctx.getChildCount() == 3) {
            TACResult leftResult = visit(ctx.expr(0));
            TACResult rightResult = visit(ctx.expr(1));
            
            String op = "";
            if (ctx.OP_LT() != null) op = "<";
            else if (ctx.OP_LE() != null) op = "<=";
            else if (ctx.OP_GT() != null) op = ">";
            else if (ctx.OP_GE() != null) op = ">=";
            else if (ctx.OP_EQ() != null) op = "==";
            else if (ctx.OP_NE() != null) op = "!=";
            else if (ctx.AND() != null) op = "&&";
            else if (ctx.OR() != null) op = "||";
            
            result.place = newTemp();
            emit(result.place + " = " + leftResult.place + " " + op + " " + rightResult.place);
        }
        // Expressão com operador NOT
        else if (ctx.NOT() != null) {
            TACResult exprResult = visit(ctx.expr(0));
            
            result.place = newTemp();
            emit(result.place + " = ! " + exprResult.place);
        }
        // Expressão simples
        else {
            result = visit(ctx.expr(0));
        }
        
        return result;
    }
    
    @Override
    public TACResult visitIfStatement(MOCParser.IfStatementContext ctx) {
        TACResult conditionResult = visit(ctx.condition());
        
        String elseLabel = newLabel();
        String endIfLabel = newLabel();
        
        // Geração de código para o 'if'
        emit("IF NOT " + conditionResult.place + " GOTO " + elseLabel);
        
        // Visita o bloco 'if'
        visit(ctx.block(0));
        
        // Se tiver um bloco 'else'
        if (ctx.block().size() > 1) {
            emit("GOTO " + endIfLabel);
            emit(elseLabel + ":");
            visit(ctx.block(1));
            emit(endIfLabel + ":");
        } else {
            emit(elseLabel + ":");
        }
        
        return new TACResult();
    }
    
    @Override
    public TACResult visitWhileStatement(MOCParser.WhileStatementContext ctx) {
        String startLabel = newLabel();
        String endLabel = newLabel();
        
        emit(startLabel + ":");
        
        TACResult conditionResult = visit(ctx.condition());
        
        emit("IF NOT " + conditionResult.place + " GOTO " + endLabel);
        
        // Visita o bloco do while
        visit(ctx.block());
        
        emit("GOTO " + startLabel);
        emit(endLabel + ":");
        
        return new TACResult();
    }
    
    @Override
    public TACResult visitForStatement(MOCParser.ForStatementContext ctx) {
        String startLabel = newLabel();
        String endLabel = newLabel();
        
        // Inicialização
        visit(ctx.assignment(0));
        
        emit(startLabel + ":");
        
        // Condição
        TACResult conditionResult = visit(ctx.condition());
        emit("IF NOT " + conditionResult.place + " GOTO " + endLabel);
        
        // Corpo do for
        visit(ctx.block());
        
        // Atualização
        visit(ctx.assignment(1));
        
        emit("GOTO " + startLabel);
        emit(endLabel + ":");
        
        return new TACResult();
    }
    
    @Override
    public TACResult visitReturnStatement(MOCParser.ReturnStatementContext ctx) {
        TACResult exprResult = visit(ctx.expr());
        
        emit("RETURN " + exprResult.place);
        
        return new TACResult();
    }
    
    @Override
    public TACResult visitWriteFunction(MOCParser.WriteFunctionContext ctx) {
        if (ctx.WRITE() != null) {
            TACResult exprResult = visit(ctx.expr());
            emit("WRITE " + exprResult.place);
        } else if (ctx.WRITEC() != null) {
            TACResult exprResult = visit(ctx.expr());
            emit("WRITEC " + exprResult.place);
        } else if (ctx.WRITEV() != null) {
            String id = ctx.ID().getText();
            emit("WRITEV " + id);
        } else if (ctx.WRITES() != null) {
            if (ctx.ID() != null) {
                String id = ctx.ID().getText();
                emit("WRITES " + id);
            } else if (ctx.STRING_LITERAL() != null) {
                String str = ctx.STRING_LITERAL().getText();
                emit("WRITES " + str);
            }
        }
        
        return new TACResult();
    }
}

