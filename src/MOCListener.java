// Generated from MOC.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MOCParser}.
 */
public interface MOCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MOCParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(MOCParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(MOCParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#prototype}.
	 * @param ctx the parse tree
	 */
	void enterPrototype(MOCParser.PrototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#prototype}.
	 * @param ctx the parse tree
	 */
	void exitPrototype(MOCParser.PrototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(MOCParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(MOCParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(MOCParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(MOCParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(MOCParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(MOCParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void enterMainFunction(MOCParser.MainFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void exitMainFunction(MOCParser.MainFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MOCParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MOCParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MOCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MOCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MOCParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MOCParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#simpleDeclList}.
	 * @param ctx the parse tree
	 */
	void enterSimpleDeclList(MOCParser.SimpleDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#simpleDeclList}.
	 * @param ctx the parse tree
	 */
	void exitSimpleDeclList(MOCParser.SimpleDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#simpleDecl}.
	 * @param ctx the parse tree
	 */
	void enterSimpleDecl(MOCParser.SimpleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#simpleDecl}.
	 * @param ctx the parse tree
	 */
	void exitSimpleDecl(MOCParser.SimpleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#arrayDeclList}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclList(MOCParser.ArrayDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#arrayDeclList}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclList(MOCParser.ArrayDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(MOCParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(MOCParser.ArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#arraySuffix}.
	 * @param ctx the parse tree
	 */
	void enterArraySuffix(MOCParser.ArraySuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#arraySuffix}.
	 * @param ctx the parse tree
	 */
	void exitArraySuffix(MOCParser.ArraySuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#initValue}.
	 * @param ctx the parse tree
	 */
	void enterInitValue(MOCParser.InitValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#initValue}.
	 * @param ctx the parse tree
	 */
	void exitInitValue(MOCParser.InitValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(MOCParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(MOCParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#inputFunction}.
	 * @param ctx the parse tree
	 */
	void enterInputFunction(MOCParser.InputFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#inputFunction}.
	 * @param ctx the parse tree
	 */
	void exitInputFunction(MOCParser.InputFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MOCParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MOCParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MOCParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MOCParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MOCParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MOCParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#casting}.
	 * @param ctx the parse tree
	 */
	void enterCasting(MOCParser.CastingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#casting}.
	 * @param ctx the parse tree
	 */
	void exitCasting(MOCParser.CastingContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MOCParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MOCParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MOCParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MOCParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MOCParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MOCParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MOCParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MOCParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MOCParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MOCParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#writeFunction}.
	 * @param ctx the parse tree
	 */
	void enterWriteFunction(MOCParser.WriteFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#writeFunction}.
	 * @param ctx the parse tree
	 */
	void exitWriteFunction(MOCParser.WriteFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MOCParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MOCParser.TypeContext ctx);
}