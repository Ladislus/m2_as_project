package utils

import antlr.parser.WhileBaseVisitor
import antlr.parser.WhileParser
import ast.Node

class ASTBuilder : WhileBaseVisitor<Node>() {
    override fun visitProgram(ctx: WhileParser.ProgramContext): Node {
        TODO("Not yet implemented")
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