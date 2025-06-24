import org.antlr.v4.runtime.tree.ParseTreeProperty;

// Classe responsável por visitar a árvore sintática abstrata (AST) gerada pelo parser MOC
// e produzir o código TAC (Three-Address Code) correspondente.
// Implementa o padrão Visitor para percorrer a AST.
public class MOCTACVisitor extends MOCBaseVisitor<TACResult> {
    private TAC tac;                            // Objeto que armazena o código TAC gerado
    private ParseTreeProperty<String> scopes;   // Mapeia nós da árvore para seus scopes
    private String currentScope;                // scope atual durante a visitação
    
    // Construtor padrão, inicializa o gerador TAC e o sistema de scope
    public MOCTACVisitor() {
        this.tac = new TAC();
        this.scopes = new ParseTreeProperty<>();
        this.currentScope = "global";
    }
    
    // Obtém o objeto TAC gerado após as visitas
    public TAC getTAC() {
        return tac;
    }
    
    // Visita o nó raiz da AST, processando todas as declarações e a função main
    @Override
    public TACResult visitStart(MOCParser.StartContext ctx) {
        // Visita todas as declarações de protótipo, funções e variáveis
        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            visit(ctx.getChild(i));
        }
        
        // Visita a função main
        return visit(ctx.mainFunction());
    }
    
    // Processa declarações de protótipos de funções
    // Não gera código TAC, pois protótipos são apenas declarações
    @Override
    public TACResult visitPrototype(MOCParser.PrototypeContext ctx) {
        // Protótipos são apenas declarações, não geramos código TAC para eles
        return null;
    }
    
    // Processa declarações de funções, gerando o código TAC correspondente
    @Override
    public TACResult visitFunctionDecl(MOCParser.FunctionDeclContext ctx) {
        String functionName = ctx.ID().getText();
        
        // Define o scope atual como o nome da função
        currentScope = functionName;
        
        // Adiciona etiqueta de início da função
        String functionLabel = functionName + "_start";
        tac.addLabel(functionLabel);
        
        // Processa parâmetros se existirem
        if (ctx.paramList() != null) {
            visit(ctx.paramList());
        }
        
        // Visita o bloco da função
        visit(ctx.block());
        
        // Se a função é void e não tem return explícito, adiciona um return vazio
        if (ctx.type().getText().equals("void")) {
            tac.addReturn(null);
        }
        
        // Adiciona etiqueta de fim da função
        String endLabel = functionName + "_end";
        tac.addLabel(endLabel);
        
        // Restaura o scope global
        currentScope = "global";
        
        return null;
    }
    
    // Processa a função main, que é obrigatória em programas MOC
    @Override
    public TACResult visitMainFunction(MOCParser.MainFunctionContext ctx) {
        // Define o scope atual como main
        currentScope = "main";
        
        // Adiciona etiqueta de início da função main
        tac.addLabel("main_start");
        
        // Visita o bloco da função main
        visit(ctx.block());
        
        // Adiciona um return implícito para main
        tac.addReturn(null);
        
        // Adiciona etiqueta de fim da função main
        tac.addLabel("main_end");
        
        // Restaura o scope global
        currentScope = "global";
        
        return null;
    }
    
    // Processa a lista de parâmetros de uma função
    @Override
    public TACResult visitParamList(MOCParser.ParamListContext ctx) {
        // Visita cada parâmetro
        for (MOCParser.ParamContext param : ctx.param()) {
            visit(param);
        }
        return null;
    }
    
    // Processa um parâmetro individual de função
    @Override
    public TACResult visitParam(MOCParser.ParamContext ctx) {
        // Se o parâmetro tem um identificador
        if (ctx.ID() != null) {
            String paramName = ctx.ID().getText();
            String paramType = ctx.type().getText();
            
            // Registra o parâmetro no scope atual
            // Nota: Aqui não geramos código TAC específico para parâmetros,
            // pois eles são tratados implicitamente na chamada da função
        }
        return null;
    }
    
    // Processa um bloco de código (conjunto de instruções entre chaves)
    @Override
    public TACResult visitBlock(MOCParser.BlockContext ctx) {
        // Visita todos os statements dentro do bloco
        for (MOCParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        return null;
    }
    
    // Processa declarações de variáveis, tanto simples quanto arrays
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
        
        return null;
    }
    
    // Processa uma lista de declarações de variáveis simples
    @Override
    public TACResult visitSimpleDeclList(MOCParser.SimpleDeclListContext ctx) {
        // Visita cada declaração simples
        for (MOCParser.SimpleDeclContext simpleDecl : ctx.simpleDecl()) {
            visit(simpleDecl);
        }
        return null;
    }
    
    // Processa uma declaração de variável simples, com possível inicialização
    @Override
    public TACResult visitSimpleDecl(MOCParser.SimpleDeclContext ctx) {
        String id = ctx.ID().getText();
        
        // Se houver inicialização
        if (ctx.initValue() != null) {
            TACResult initResult = visit(ctx.initValue());
            tac.addAssignment(id, initResult.place);
        }
        
        return null;
    }
    
    /**
     * Processa uma lista de declarações de arrays
     */
    @Override
    public TACResult visitArrayDeclList(MOCParser.ArrayDeclListContext ctx) {
        // Visita cada declaração de array
        for (MOCParser.ArrayDeclContext arrayDecl : ctx.arrayDecl()) {
            visit(arrayDecl);
        }
        return null;
    }
    
    /**
     * Processa uma declaração de array, com possível inicialização
     */
    @Override
    public TACResult visitArrayDecl(MOCParser.ArrayDeclContext ctx) {
        String id = ctx.ID().getText();
        
        // Visita a parte do sufixo de array para obter o tamanho
        TACResult arraySuffixResult = visit(ctx.arraySuffix());
        
        // Se houver inicialização
        if (ctx.initValue() != null) {
            TACResult initResult = visit(ctx.initValue());
            
            // Se for inicialização com lista de valores
            if (initResult.isArrayInit && initResult.places != null) {
                for (int i = 0; i < initResult.places.size(); i++) {
                    String index = String.valueOf(i);
                    tac.addArrayStore(id, index, initResult.places.get(i));
                }
            }
            // Se for inicialização com um único valor (todos os elementos receberão o mesmo valor)
            else if (!initResult.isArrayInit && arraySuffixResult.size != null) {
                int size = Integer.parseInt(arraySuffixResult.size);
                for (int i = 0; i < size; i++) {
                    String index = String.valueOf(i);
                    tac.addArrayStore(id, index, initResult.place);
                }
            }
        }
        
        return null;
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
            result = visit(ctx.exprList());
            result.isArrayInit = true;
        }
        
        return result;
    }
    
    @Override
    public TACResult visitExprList(MOCParser.ExprListContext ctx) {
        TACResult result = new TACResult();
        result.places = new java.util.ArrayList<>();
        
        // Visita cada expressão na lista
        for (MOCParser.ExprContext expr : ctx.expr()) {
            TACResult exprResult = visit(expr);
            result.places.add(exprResult.place);
        }
        
        result.size = String.valueOf(result.places.size());
        
        return result;
    }
    
    @Override
    public TACResult visitInputFunction(MOCParser.InputFunctionContext ctx) {
        TACResult result = new TACResult();
        result.place = tac.newTemp();
        
        if (ctx.READ() != null) {
            // Para read(), criamos um temporário que recebe o resultado da leitura
            tac.addArithmetic("READ", null, null, result.place);
        } else if (ctx.READC() != null) {
            tac.addArithmetic("READC", null, null, result.place);
        } else if (ctx.READS() != null) {
            tac.addArithmetic("READS", null, null, result.place);
        }
        
        return result;
    }
    
    @Override
    public TACResult visitAssignment(MOCParser.AssignmentContext ctx) {
        // Se for atribuição simples
        if (ctx.LBRACK() == null) {
            String id = ctx.ID().getText();
            TACResult exprResult = visit(ctx.expr(0));
            
            tac.addAssignment(id, exprResult.place);
            
            TACResult result = new TACResult();
            result.place = id;
            return result;
        }
        // Se for atribuição a um elemento de array
        else {
            String id = ctx.ID().getText();
            TACResult indexResult = visit(ctx.expr(0));
            TACResult valueResult = visit(ctx.expr(1));
            
            tac.addArrayStore(id, indexResult.place, valueResult.place);
            
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
            
            result.place = tac.newTemp();
            tac.addArithmetic(op, left.place, right.place, result.place);
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
            
            result.place = tac.newTemp();
            tac.addArrayLoad(id, indexResult.place, result.place);
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
        
        // Processa os argumentos da chamada
        if (ctx.expr() != null && !ctx.expr().isEmpty()) {
            for (MOCParser.ExprContext expr : ctx.expr()) {
                TACResult exprResult = visit(expr);
                tac.addParam(exprResult.place);
            }
        }
        
        TACResult result = new TACResult();
        result.place = tac.newTemp();
        
        tac.addCall(functionName, result.place);
        
        return result;
    }
    
    @Override
    public TACResult visitCasting(MOCParser.CastingContext ctx) {
        String type = ctx.type().getText();
        TACResult exprResult = visit(ctx.expr());
        
        TACResult result = new TACResult();
        result.place = tac.newTemp();
        
        tac.addArithmetic("CAST_" + type, exprResult.place, null, result.place);
        
        return result;
    }
    
    @Override
    public TACResult visitCondition(MOCParser.ConditionContext ctx) {
        TACResult result = new TACResult();
        
        // Expressão com operador relacional ou lógico
        if (ctx.getChildCount() == 3 && 
            (ctx.OP_LT() != null || ctx.OP_LE() != null || ctx.OP_GT() != null || 
             ctx.OP_GE() != null || ctx.OP_EQ() != null || ctx.OP_NE() != null ||
             ctx.AND() != null || ctx.OR() != null)) {
            
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
            
            result.place = tac.newTemp();
            tac.addArithmetic(op, leftResult.place, rightResult.place, result.place);
        }
        // Expressão com operador NOT
        else if (ctx.NOT() != null) {
            TACResult exprResult = visit(ctx.expr(0));
            
            result.place = tac.newTemp();
            tac.addArithmetic("!", exprResult.place, null, result.place);
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
        
        String elseLabel = tac.newLabel();
        String endIfLabel = tac.newLabel();
        
        // Geração de código para o 'if'
        tac.addIfFalse(conditionResult.place, elseLabel);
        
        // Visita o bloco 'if'
        visit(ctx.block(0));
        
        // Se tiver um bloco 'else'
        if (ctx.block().size() > 1) {
            tac.addGoto(endIfLabel);
            tac.addLabel(elseLabel);
            visit(ctx.block(1));
            tac.addLabel(endIfLabel);
        } else {
            tac.addLabel(elseLabel);
        }
        
        return null;
    }
    
    @Override
    public TACResult visitWhileStatement(MOCParser.WhileStatementContext ctx) {
        String startLabel = tac.newLabel();
        String endLabel = tac.newLabel();
        
        tac.addLabel(startLabel);
        
        TACResult conditionResult = visit(ctx.condition());
        
        tac.addIfFalse(conditionResult.place, endLabel);
        
        // Visita o bloco do while
        visit(ctx.block());
        
        tac.addGoto(startLabel);
        tac.addLabel(endLabel);
        
        return null;
    }
    
    @Override
    public TACResult visitForStatement(MOCParser.ForStatementContext ctx) {
        String startLabel = tac.newLabel();
        String endLabel = tac.newLabel();
        
        // Inicialização
        visit(ctx.assignment(0));
        
        tac.addLabel(startLabel);
        
        // Condição
        TACResult conditionResult = visit(ctx.condition());
        tac.addIfFalse(conditionResult.place, endLabel);
        
        // Corpo do for
        visit(ctx.block());
        
        // Atualização
        visit(ctx.assignment(1));
        
        tac.addGoto(startLabel);
        tac.addLabel(endLabel);
        
        return null;
    }
    
    @Override
    public TACResult visitReturnStatement(MOCParser.ReturnStatementContext ctx) {
        TACResult exprResult = visit(ctx.expr());
        
        tac.addReturn(exprResult.place);
        
        return null;
    }
    
    @Override
    public TACResult visitWriteFunction(MOCParser.WriteFunctionContext ctx) {
        if (ctx.WRITE() != null) {
            TACResult exprResult = visit(ctx.expr());
            tac.addArithmetic("WRITE", exprResult.place, null, null);
        } else if (ctx.WRITEC() != null) {
            TACResult exprResult = visit(ctx.expr());
            tac.addArithmetic("WRITEC", exprResult.place, null, null);
        } else if (ctx.WRITEV() != null) {
            String id = ctx.ID().getText();
            tac.addArithmetic("WRITEV", id, null, null);
        } else if (ctx.WRITES() != null) {
            if (ctx.ID() != null) {
                String id = ctx.ID().getText();
                tac.addArithmetic("WRITES", id, null, null);
            } else if (ctx.STRING_LITERAL() != null) {
                String str = ctx.STRING_LITERAL().getText();
                tac.addArithmetic("WRITES", str, null, null);
            }
        }
        
        return null;
    }
}

class TACResult {
    public String place;        // Local onde o resultado está armazenado (nome da variável ou temporário)
    public String type;         // Tipo do resultado
    public String size;         // Tamanho (para arrays)
    public java.util.List<String> places; // Lista de lugares (para inicialização de arrays)
    public boolean isArrayInit; // Indica se é uma inicialização de array
    
    public TACResult() {
        this.isArrayInit = false;
    }
}
