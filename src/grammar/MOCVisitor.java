// Generated from grammar\MOC.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MOCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MOCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MOCParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MOCParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#prototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrototype(MOCParser.PrototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(MOCParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(MOCParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(MOCParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#mainFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFunction(MOCParser.MainFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MOCParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MOCParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MOCParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#simpleDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDeclList(MOCParser.SimpleDeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#simpleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDecl(MOCParser.SimpleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#arrayDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclList(MOCParser.ArrayDeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDecl(MOCParser.ArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#arraySuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySuffix(MOCParser.ArraySuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#initValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitValue(MOCParser.InitValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(MOCParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#inputFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputFunction(MOCParser.InputFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MOCParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MOCParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MOCParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#casting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasting(MOCParser.CastingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MOCParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MOCParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MOCParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MOCParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MOCParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#writeFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteFunction(MOCParser.WriteFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MOCParser.TypeContext ctx);
}