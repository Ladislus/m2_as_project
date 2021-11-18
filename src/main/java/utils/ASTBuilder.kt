package utils

import antlr.parser.WhileBaseVisitor
import antlr.parser.WhileParser
import ast.*
import ast.statement.Statement
import org.antlr.v4.runtime.ParserRuleContext

class ASTBuilder : WhileBaseVisitor<Node>() {

    @Suppress("UNCHECKED_CAST")
    private fun <T> makeList(contexts: List<ParserRuleContext>): List<T> {
        val nodes: MutableList<T> = mutableListOf()
        for (ctx: ParserRuleContext in contexts) nodes += ctx.accept(this) as T
        return nodes
    }

    private fun makePosition(ctx: ParserRuleContext): Position {
        return Position(ctx.start.line, ctx.start.charPositionInLine)
    }

    override fun visitProgram(ctx: WhileParser.ProgramContext): Node {
        val procedures: List<Procedure> = makeList(ctx.declaration())
        val variables: List<Variable> = makeList(listOf(ctx.variablesDeclarationList()))
        val statements: List<Statement> = makeList(listOf(ctx.statements()))

        TODO("Not yet implemented")

        return Program(makePosition(ctx), ctx.Identifier().text ,procedures, variables, statements)
    }

    override fun visitDeclaration(ctx: WhileParser.DeclarationContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitIdentifierDeclarationList(ctx: WhileParser.IdentifierDeclarationListContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitVariablesDeclarationList(ctx: WhileParser.VariablesDeclarationListContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitVariablesDeclaration(ctx: WhileParser.VariablesDeclarationContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitIdentifierList(ctx: WhileParser.IdentifierListContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitType(ctx: WhileParser.TypeContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitSimpleStatement(ctx: WhileParser.SimpleStatementContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitParenthesizedStatement(ctx: WhileParser.ParenthesizedStatementContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitStatements(ctx: WhileParser.StatementsContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitSkipStatement(ctx: WhileParser.SkipStatementContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitIfStatement(ctx: WhileParser.IfStatementContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitWhileStatement(ctx: WhileParser.WhileStatementContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitCallStatement(ctx: WhileParser.CallStatementContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitAssignmentStatement(ctx: WhileParser.AssignmentStatementContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitArithmeticExpressionList(ctx: WhileParser.ArithmeticExpressionListContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitParenthesizedArithmeticExpression(ctx: WhileParser.ParenthesizedArithmeticExpressionContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitMulDivArithmeticExpression(ctx: WhileParser.MulDivArithmeticExpressionContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitConstantArithmeticExpression(ctx: WhileParser.ConstantArithmeticExpressionContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitIdentifierArithmeticExpression(ctx: WhileParser.IdentifierArithmeticExpressionContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitAddSubArithmeticExpression(ctx: WhileParser.AddSubArithmeticExpressionContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitNegationArithmeticExpression(ctx: WhileParser.NegationArithmeticExpressionContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitBooleanValueBooleanExpression(ctx: WhileParser.BooleanValueBooleanExpressionContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitComparisonBooleanExpression(ctx: WhileParser.ComparisonBooleanExpressionContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitNegationBooleanExpression(ctx: WhileParser.NegationBooleanExpressionContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitParenthesizedBooleanExpression(ctx: WhileParser.ParenthesizedBooleanExpressionContext): Node {
        TODO("Not yet implemented")
    }

    override fun visitConstant(ctx: WhileParser.ConstantContext): Node {
        TODO("Not yet implemented")
    }
}