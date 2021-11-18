package antlr.parser;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public abstract class WhileBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements WhileVisitor<T> {
	@Override abstract public T visitProgram(WhileParser.ProgramContext ctx);
    @Override abstract public T visitDeclaration(WhileParser.DeclarationContext ctx);
    @Override abstract public T visitIdentifierDeclarationList(WhileParser.IdentifierDeclarationListContext ctx);
    @Override abstract public T visitVariablesDeclarationList(WhileParser.VariablesDeclarationListContext ctx);
    @Override abstract public T visitVariablesDeclaration(WhileParser.VariablesDeclarationContext ctx);
    @Override abstract public T visitIdentifierList(WhileParser.IdentifierListContext ctx);
    @Override abstract public T visitType(WhileParser.TypeContext ctx);
    @Override abstract public T visitSimpleStatement(WhileParser.SimpleStatementContext ctx);
    @Override abstract public T visitParenthesizedStatement(WhileParser.ParenthesizedStatementContext ctx);
    @Override abstract public T visitStatements(WhileParser.StatementsContext ctx);
    @Override abstract public T visitSkipStatement(WhileParser.SkipStatementContext ctx);
    @Override abstract public T visitIfStatement(WhileParser.IfStatementContext ctx);
	@Override abstract public T visitWhileStatement(WhileParser.WhileStatementContext ctx);
	@Override abstract public T visitCallStatement(WhileParser.CallStatementContext ctx);
	@Override abstract public T visitAssignmentStatement(WhileParser.AssignmentStatementContext ctx);
	@Override abstract public T visitArithmeticExpressionList(WhileParser.ArithmeticExpressionListContext ctx);
	@Override abstract public T visitParenthesizedArithmeticExpression(WhileParser.ParenthesizedArithmeticExpressionContext ctx);
	@Override abstract public T visitMulDivArithmeticExpression(WhileParser.MulDivArithmeticExpressionContext ctx);
	@Override abstract public T visitConstantArithmeticExpression(WhileParser.ConstantArithmeticExpressionContext ctx);
	@Override abstract public T visitIdentifierArithmeticExpression(WhileParser.IdentifierArithmeticExpressionContext ctx);
	@Override abstract public T visitAddSubArithmeticExpression(WhileParser.AddSubArithmeticExpressionContext ctx);
	@Override abstract public T visitNegationArithmeticExpression(WhileParser.NegationArithmeticExpressionContext ctx);
	@Override abstract public T visitBooleanValueBooleanExpression(WhileParser.BooleanValueBooleanExpressionContext ctx);
	@Override abstract public T visitComparisonBooleanExpression(WhileParser.ComparisonBooleanExpressionContext ctx);
	@Override abstract public T visitNegationBooleanExpression(WhileParser.NegationBooleanExpressionContext ctx);
	@Override abstract public T visitParenthesizedBooleanExpression(WhileParser.ParenthesizedBooleanExpressionContext ctx);
	@Override abstract public T visitConstant(WhileParser.ConstantContext ctx);
}