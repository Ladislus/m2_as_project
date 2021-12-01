package utils

import antlr.parser.WhileBaseVisitor
import antlr.parser.WhileParser
import ast.*
import ast.expression.arithmetic.IdentifierExpression
import ast.expression.arithmetic.*
import ast.expression.bool.*
import ast.statement.*
import org.antlr.v4.runtime.ParserRuleContext

class ASTBuilder : WhileBaseVisitor<Node>() {

    @Suppress("UNCHECKED_CAST")
    private fun <T> makeList(contexts: List<ParserRuleContext>): List<T> {
        val nodes: MutableList<T> = mutableListOf()
        for (ctx: ParserRuleContext in contexts) nodes += ctx.accept(this) as T
        return nodes
    }

    private fun makePosition(ctx: ParserRuleContext): Position =
        Position(ctx.start.line, ctx.start.charPositionInLine)

    private fun raiseError(methodName: String): Nothing =
        throw IllegalStateException("Method $methodName should never be visited")

    override fun visitProgram(ctx: WhileParser.ProgramContext): Node =
        Program(
            makePosition(ctx),
            ctx.programName?.text,
            makeList(ctx.procedureDeclaration()),
            makeList(ctx.variablesDeclaration()),
            makeList(ctx.statementList().statement())
        )

    override fun visitProcedureDeclaration(ctx: WhileParser.ProcedureDeclarationContext): Node =
        Procedure(
            makePosition(ctx),
            ctx.procedureName.text,
            makeList(ctx.identifierDeclarationList().identifierDeclaration()),
            if (ctx.returnType != null) {
                Variable(
                    makePosition(ctx),
                    ctx.returnType.accept(this) as Type,
                    ctx.returnIdentifier.text
                )
            } else null,
            makeList(ctx.statementList().statement())
        )

    override fun visitIdentifierDeclarationList(ctx: WhileParser.IdentifierDeclarationListContext): Node =
        raiseError("visitIdentifierDeclarationList")

    override fun visitIdentifierDeclaration(ctx: WhileParser.IdentifierDeclarationContext): Node =
        Variable(
            makePosition(ctx),
            ctx.type().accept(this) as Type,
            ctx.Identifier().text
        )

    override fun visitVariablesDeclaration(ctx: WhileParser.VariablesDeclarationContext): Node {
        val type = ctx.type().accept(this) as Type
        val position = makePosition(ctx.identifierList())
        val variables = mutableListOf<Variable>()
        for (identifier in ctx.identifierList().Identifier())
            variables += Variable(
                position,
                type,
                identifier.text
            )
        // FIXME : VariableBlock stored inside Program._variables (Cause error later in visitor)
        return VariableBlock(
            makePosition(ctx),
            variables
        )
    }

    override fun visitIdentifierList(ctx: WhileParser.IdentifierListContext): Nothing =
        raiseError("visitIdentifierList")

    override fun visitType(ctx: WhileParser.TypeContext): Node =
        Type(
            makePosition(ctx),
            typeFromString(ctx.Type().text)
        )

    override fun visitSimpleStatement(ctx: WhileParser.SimpleStatementContext): Node =
        // Even if there is only one statement, we still need to wrap it in a block (for IfStatement, ....)
        Block(
            makePosition(ctx),
            listOf(ctx.statement().accept(this) as Statement)
        )

    override fun visitParenthesizedStatement(ctx: WhileParser.ParenthesizedStatementContext): Node =
        Block(
            makePosition(ctx),
            makeList(ctx.statementList().statement())
        )

    override fun visitStatementList(ctx: WhileParser.StatementListContext): Nothing =
        raiseError("visitStatementList")

    override fun visitSkipStatement(ctx: WhileParser.SkipStatementContext): Node =
        SkipStatement(makePosition(ctx))

    override fun visitIfStatement(ctx: WhileParser.IfStatementContext): Node =
        IfStatement(
            makePosition(ctx),
            ctx.booleanExpression().accept(this) as BooleanExpression,
            ctx.thenBlock.accept(this) as Block,
            if (ctx.elseBlock != null)
                ctx.elseBlock.accept(this) as Block
            else null
        )

    override fun visitWhileStatement(ctx: WhileParser.WhileStatementContext): Node =
        WhileStatement(
            makePosition(ctx),
            ctx.booleanExpression().accept(this) as BooleanExpression,
            ctx.block().accept(this) as Block
        )

    override fun visitCallStatement(ctx: WhileParser.CallStatementContext): Node =
        CallStatement(
            makePosition(ctx),
            ctx.Identifier().text,
            makeList(ctx.arithmeticExpressionList().arithmeticExpression())
        )

    override fun visitAssignmentStatement(ctx: WhileParser.AssignmentStatementContext): Node =
        AssignStatement(
            makePosition(ctx),
            ctx.Identifier().text,
            ctx.arithmeticExpression().accept(this) as ArithmeticExpression
        )

    override fun visitArithmeticExpressionList(ctx: WhileParser.ArithmeticExpressionListContext): Nothing =
        raiseError("visitArithmeticExpressionList")

    override fun visitParenthesizedArithmeticExpression(ctx: WhileParser.ParenthesizedArithmeticExpressionContext): Node =
        ctx.arithmeticExpression().accept(this)

    override fun visitMulDivArithmeticExpression(ctx: WhileParser.MulDivArithmeticExpressionContext): Node =
        BinaryArithmeticExpression(
            makePosition(ctx),
            ctx.leftSide.accept(this) as ArithmeticExpression,
            binaryArithmeticOperatorFromString(ctx.op.text),
            ctx.rightSide.accept(this) as ArithmeticExpression
        )

    override fun visitConstantArithmeticExpression(ctx: WhileParser.ConstantArithmeticExpressionContext): Node =
        ctx.constant().accept(this)

    override fun visitIdentifierArithmeticExpression(ctx: WhileParser.IdentifierArithmeticExpressionContext): Node =
        IdentifierExpression(
            makePosition(ctx),
            ctx.Identifier().text
        )

    override fun visitAddSubArithmeticExpression(ctx: WhileParser.AddSubArithmeticExpressionContext): Node =
        BinaryArithmeticExpression(
            makePosition(ctx),
            ctx.leftSide.accept(this) as ArithmeticExpression,
            binaryArithmeticOperatorFromString(ctx.op.text),
            ctx.rightSide.accept(this) as ArithmeticExpression
        )

    override fun visitNegationArithmeticExpression(ctx: WhileParser.NegationArithmeticExpressionContext): Node =
        UnaryArithmeticExpression(
            makePosition(ctx),
            ctx.arithmeticExpression().accept(this) as ArithmeticExpression,
            unaryArithmeticOperatorFromString(ctx.Minus().text)
        )

    override fun visitBooleanValueBooleanExpression(ctx: WhileParser.BooleanValueBooleanExpressionContext): Node =
        BooleanConstant(
            makePosition(ctx),
            ctx.BooleanValue().text.toBoolean()
        )

    override fun visitComparisonBooleanExpression(ctx: WhileParser.ComparisonBooleanExpressionContext): Node =
        BinaryBooleanExpression(
            makePosition(ctx),
            ctx.leftSide.accept(this) as ArithmeticExpression,
            binaryBooleanOperatorFromString(ctx.op.text),
            ctx.rightSide.accept(this) as ArithmeticExpression
        )

    override fun visitNegationBooleanExpression(ctx: WhileParser.NegationBooleanExpressionContext): Node =
        UnaryBooleanExpression(
            makePosition(ctx),
            ctx.booleanExpression().accept(this) as BooleanExpression,
            unaryBooleanOperatorFromString(ctx.Negation().text)
        )

    override fun visitParenthesizedBooleanExpression(ctx: WhileParser.ParenthesizedBooleanExpressionContext): Node =
        ctx.booleanExpression().accept(this)

    override fun visitConstant(ctx: WhileParser.ConstantContext): Node =
        ArithmeticConstant(
            makePosition(ctx),
            ctx.Minus()?.let{
                -ctx.IntegerValue().text.toInt()
            } ?: ctx.IntegerValue().text.toInt()
        )
}