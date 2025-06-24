grammar MOC;

//Tokens
INT_TYPE       : 'int';
DOUBLE_TYPE    : 'double';
VOID_TYPE      : 'void';
IF             : 'if';
ELSE           : 'else';
WHILE          : 'while';
FOR            : 'for';
RETURN         : 'return';
READ           : 'read';
READC          : 'readc';
READS          : 'reads';
WRITE          : 'write';
WRITEC         : 'writec';
WRITEV         : 'writev';
WRITES         : 'writes';

// Operadores condicionais e lógicos
OP_LT          : '<';
OP_LE          : '<=';
OP_GT          : '>';
OP_GE          : '>=';
OP_EQ          : '==';
OP_NE          : '!=';
AND            : '&&';
OR             : '||';
NOT            : '!';

// Outros tokens literais
LPAREN         : '(';
RPAREN         : ')';
LBRACE         : '{';
RBRACE         : '}';
LBRACK         : '[';
RBRACK         : ']';
SEMI           : ';';
COMMA          : ',';
ASSIGN         : '=';

PLUS           : '+';
MINUS          : '-';
MULT           : '*';
DIV            : '/';
MOD            : '%';

QUOTE          : '"' ;

// Literais numéricos e string
DOUBLE_LITERAL : [0-9]+ '.' [0-9]+ ;
INT_LITERAL    : [0-9]+ ;
STRING_LITERAL : '"' (~["\r\n])* '"' ;

// Identificador
ID             : [a-zA-Z_][a-zA-Z0-9_]* ;

// Espaços ignorados
WS             : [ \t\r\n]+ -> skip ;

// Comentários ignorados
LINE_COMMENT   : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT  : '/*' .*? '*/' -> skip ;

// Regras do Parser

// Regra de início: permite declarações de protótipos, funções e variáveis
start
    : (prototype | functionDecl | varDecl)* mainFunction
    ;

// Protótipos
prototype
    : type ID LPAREN paramList? RPAREN SEMI
    | VOID_TYPE 'main' LPAREN 'void' RPAREN SEMI
    ;

// Declaração de função
functionDecl
    : type ID LPAREN paramList? RPAREN block
    ;

// Lista de parâmetros
paramList
    : param (COMMA param)*
    ;
param
    : type (ID)? (LBRACK RBRACK)? 
    ;

// Declaração obrigatória da main
mainFunction
    : VOID_TYPE 'main' LPAREN 'void' RPAREN block
    ;

// Bloco: uma série de statements
block
    : LBRACE statement* RBRACE
    ;

// Statements gerais
statement
    : varDecl
    | ifStatement
    | whileStatement
    | forStatement
    | writeFunction
    | returnStatement
    | functionCall SEMI
    | assignment SEMI
    ;

// Declarações SEPARADAS: ou só simples, ou só arrays
varDecl
    : type simpleDeclList ';'      // só variáveis simples
    | type arrayDeclList ';'       // só arrays
    ;

// Lista de declarações simples
simpleDeclList
    : simpleDecl (',' simpleDecl)* 
    ;

// Declara invidiual de uma var simples, com ou sem init
simpleDecl
    : ID ( ASSIGN initValue )?
    ;

// Lista de declaracões de arrays
arrayDeclList
    : arrayDecl (',' arrayDecl)* 
    ;

// Declaração individual de um array, com ou sem inicialização
arrayDecl
    : ID arraySuffix ( ASSIGN initValue )?
    ;

// Sufixo de array: pode ser explícito ou deduzido
arraySuffix
    : '[' INT_LITERAL ']'          // tamanho explícito
    | '[' ']'                      // tamanho deduzido
    ;    

// Valor de inicialização: pode ser uma expressão, uma função de input ou uma lista de expressões
initValue
    : expr
    | inputFunction
    | LBRACE exprList RBRACE
    ;

// Lista de expressões separadas por vírgula (usada na inicialização de vetores)
exprList
    : expr (COMMA expr)*
    ;

// Funções de input: read(), readc() e reads()
inputFunction
    : READ LPAREN RPAREN
    | READC LPAREN RPAREN
    | READS LPAREN RPAREN
    ;

// Atribuições simples ou à posição de vetor
assignment
    : ID ASSIGN expr
    | ID LBRACK expr RBRACK ASSIGN expr
    ;

// Expressões: são construídas de forma recursiva
expr
    : expr (PLUS | MINUS) expr
    | expr (MULT | DIV | MOD) expr
    | LPAREN expr RPAREN
    | functionCall
    | casting
    | inputFunction
    | ID LBRACK expr RBRACK
    | ID
    | INT_LITERAL
    | DOUBLE_LITERAL
    | STRING_LITERAL
    ;

// Chamada de função
functionCall
    : ID LPAREN ( expr (COMMA expr)* )? RPAREN
    ;

// Casting: permite cast para int ou double
casting
    : LPAREN type RPAREN expr
    ;

// Condição: pode ser do tipo "expr op expr" ou "! expr" ou somente uma expressão
condition
    : expr ( (OP_LT | OP_LE | OP_GT | OP_GE | OP_EQ | OP_NE | AND | OR) expr )?
    | NOT expr
    ;

// Estruturas condicionais e de repetição
ifStatement
    : IF LPAREN condition RPAREN block ( ELSE block )?
    ;
whileStatement
    : WHILE LPAREN condition RPAREN block
    ;
forStatement
    : FOR LPAREN assignment SEMI condition SEMI assignment RPAREN block
    ;

// Retorno de função: sempre acompanhado de uma expressão e terminado com ;
returnStatement
    : RETURN expr SEMI
    ;

// Funções de escrita: write, writec, writev e writes
writeFunction
    : WRITE LPAREN expr RPAREN SEMI
    | WRITEC LPAREN expr RPAREN SEMI
    | WRITEV LPAREN ID RPAREN SEMI
    | WRITES LPAREN (ID | STRING_LITERAL) RPAREN SEMI
    ;
    
// Regra para tipo (usa os tokens de palavras‐chave já definidos)
type
    : INT_TYPE
    | DOUBLE_TYPE
    | VOID_TYPE
    ;
