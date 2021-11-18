package utils;

import antlr.parser.WhileParser;
import ast.Node;
import antlr.parser.WhileBaseVisitor;
import ast.Position;
import org.antlr.v4.runtime.ParserRuleContext;

public class ASTBuilder extends WhileBaseVisitor<Node> {

    private static Position position(ParserRuleContext ctx) {
        return new Position(ctx.start.getLine(),
                ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitProgram(WhileParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitDeclaration(WhileParser.DeclarationContext ctx) {
        return super.visitDeclaration(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitIdentifierDeclarationList(WhileParser.IdentifierDeclarationListContext ctx) {
        return super.visitIdentifierDeclarationList(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitVariablesDeclarationList(WhileParser.VariablesDeclarationListContext ctx) {
        return super.visitVariablesDeclarationList(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitVariablesDeclaration(WhileParser.VariablesDeclarationContext ctx) {
        return super.visitVariablesDeclaration(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitIdentifierList(WhileParser.IdentifierListContext ctx) {
        return super.visitIdentifierList(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitType(WhileParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitSimpleStatement(WhileParser.SimpleStatementContext ctx) {
        return super.visitSimpleStatement(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitParenthesizedStatement(WhileParser.ParenthesizedStatementContext ctx) {
        return super.visitParenthesizedStatement(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitStatements(WhileParser.StatementsContext ctx) {
        return super.visitStatements(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitSkipStatement(WhileParser.SkipStatementContext ctx) {
        return super.visitSkipStatement(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitAssignmentStatement(WhileParser.AssignmentStatementContext ctx) {
        return super.visitAssignmentStatement(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitIfStatement(WhileParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitWhileStatement(WhileParser.WhileStatementContext ctx) {
        return super.visitWhileStatement(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitCallStatement(WhileParser.CallStatementContext ctx) {
        return super.visitCallStatement(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitArithmeticExpressionList(WhileParser.ArithmeticExpressionListContext ctx) {
        return super.visitArithmeticExpressionList(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitParenthesizedArithmeticExpression(WhileParser.ParenthesizedArithmeticExpressionContext ctx) {
        return super.visitParenthesizedArithmeticExpression(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitMulDivArithmeticExpression(WhileParser.MulDivArithmeticExpressionContext ctx) {
        return super.visitMulDivArithmeticExpression(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitConstantArithmeticExpression(WhileParser.ConstantArithmeticExpressionContext ctx) {
        return super.visitConstantArithmeticExpression(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitIdentifierArithmeticExpression(WhileParser.IdentifierArithmeticExpressionContext ctx) {
        return super.visitIdentifierArithmeticExpression(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitAddSubArithmeticExpression(WhileParser.AddSubArithmeticExpressionContext ctx) {
        return super.visitAddSubArithmeticExpression(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitNegationArithmeticExpression(WhileParser.NegationArithmeticExpressionContext ctx) {
        return super.visitNegationArithmeticExpression(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitBooleanValueBooleanExpression(WhileParser.BooleanValueBooleanExpressionContext ctx) {
        return super.visitBooleanValueBooleanExpression(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitComparitionBooleanExpression(WhileParser.ComparitionBooleanExpressionContext ctx) {
        return super.visitComparitionBooleanExpression(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitNegationBooleanExpression(WhileParser.NegationBooleanExpressionContext ctx) {
        return super.visitNegationBooleanExpression(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitParenthesizedBooleanExpression(WhileParser.ParenthesizedBooleanExpressionContext ctx) {
        return super.visitParenthesizedBooleanExpression(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitIdentifier(WhileParser.IdentifierContext ctx) {
        return super.visitIdentifier(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public Node visitConstant(WhileParser.ConstantContext ctx) {
        return super.visitConstant(ctx);
    }
}
