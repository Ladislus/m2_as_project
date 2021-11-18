// Generated from C:/Users/Darky/Desktop/m2_as_project/src/main/java/antlr\While.g4 by ANTLR 4.9.2
package antlr.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WhileParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WhileVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WhileParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(WhileParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(WhileParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#identifierDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierDeclarationList(WhileParser.IdentifierDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#variablesDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariablesDeclarationList(WhileParser.VariablesDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#variablesDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariablesDeclaration(WhileParser.VariablesDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(WhileParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(WhileParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleStatement}
	 * labeled alternative in {@link WhileParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(WhileParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedStatement}
	 * labeled alternative in {@link WhileParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedStatement(WhileParser.ParenthesizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(WhileParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SkipStatement}
	 * labeled alternative in {@link WhileParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipStatement(WhileParser.SkipStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link WhileParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(WhileParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link WhileParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(WhileParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallStatement}
	 * labeled alternative in {@link WhileParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStatement(WhileParser.CallStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link WhileParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(WhileParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#arithmeticExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpressionList(WhileParser.ArithmeticExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedArithmeticExpression}
	 * labeled alternative in {@link WhileParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedArithmeticExpression(WhileParser.ParenthesizedArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivArithmeticExpression}
	 * labeled alternative in {@link WhileParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivArithmeticExpression(WhileParser.MulDivArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantArithmeticExpression}
	 * labeled alternative in {@link WhileParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantArithmeticExpression(WhileParser.ConstantArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierArithmeticExpression}
	 * labeled alternative in {@link WhileParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierArithmeticExpression(WhileParser.IdentifierArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubArithmeticExpression}
	 * labeled alternative in {@link WhileParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubArithmeticExpression(WhileParser.AddSubArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegationArithmeticExpression}
	 * labeled alternative in {@link WhileParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationArithmeticExpression(WhileParser.NegationArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanValueBooleanExpression}
	 * labeled alternative in {@link WhileParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValueBooleanExpression(WhileParser.BooleanValueBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonBooleanExpression}
	 * labeled alternative in {@link WhileParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonBooleanExpression(WhileParser.ComparisonBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegationBooleanExpression}
	 * labeled alternative in {@link WhileParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationBooleanExpression(WhileParser.NegationBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedBooleanExpression}
	 * labeled alternative in {@link WhileParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedBooleanExpression(WhileParser.ParenthesizedBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(WhileParser.ConstantContext ctx);
}