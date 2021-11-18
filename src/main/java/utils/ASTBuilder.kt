package utils

import antlr.parser.WhileBaseVisitor
import antlr.parser.WhileParser.ProgramContext
import antlr.parser.WhileParser.DeclarationContext
import antlr.parser.WhileParser.IdentifierDeclarationListContext
import antlr.parser.WhileParser.VariablesDeclarationListContext
import antlr.parser.WhileParser.VariablesDeclarationContext
import antlr.parser.WhileParser.IdentifierListContext
import antlr.parser.WhileParser.TypeContext
import antlr.parser.WhileParser.SimpleStatementContext
import antlr.parser.WhileParser.ParenthesizedStatementContext
import antlr.parser.WhileParser.StatementsContext
import antlr.parser.WhileParser.SkipStatementContext
import antlr.parser.WhileParser.AssignmentStatementContext
import antlr.parser.WhileParser.IfStatementContext
import antlr.parser.WhileParser.WhileStatementContext
import antlr.parser.WhileParser.CallStatementContext
import antlr.parser.WhileParser.ArithmeticExpressionListContext
import antlr.parser.WhileParser.ParenthesizedArithmeticExpressionContext
import antlr.parser.WhileParser.MulDivArithmeticExpressionContext
import antlr.parser.WhileParser.ConstantArithmeticExpressionContext
import antlr.parser.WhileParser.IdentifierArithmeticExpressionContext
import antlr.parser.WhileParser.AddSubArithmeticExpressionContext
import antlr.parser.WhileParser.NegationArithmeticExpressionContext
import antlr.parser.WhileParser.BooleanValueBooleanExpressionContext
import antlr.parser.WhileParser.ComparitionBooleanExpressionContext
import antlr.parser.WhileParser.NegationBooleanExpressionContext
import antlr.parser.WhileParser.ParenthesizedBooleanExpressionContext
import antlr.parser.WhileParser.ConstantContext
import ast.Node
import ast.Position
import org.antlr.v4.runtime.ParserRuleContext

class ASTBuilder : WhileBaseVisitor<Node?>() {
    override fun visitProgram(ctx: ProgramContext): Node {
        return super.visitProgram(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitDeclaration(ctx: DeclarationContext): Node {
        return super.visitDeclaration(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitIdentifierDeclarationList(ctx: IdentifierDeclarationListContext): Node {
        return super.visitIdentifierDeclarationList(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitVariablesDeclarationList(ctx: VariablesDeclarationListContext): Node {
        return super.visitVariablesDeclarationList(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitVariablesDeclaration(ctx: VariablesDeclarationContext): Node {
        return super.visitVariablesDeclaration(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitIdentifierList(ctx: IdentifierListContext): Node {
        return super.visitIdentifierList(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitType(ctx: TypeContext): Node {
        return super.visitType(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitSimpleStatement(ctx: SimpleStatementContext): Node {
        return super.visitSimpleStatement(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitParenthesizedStatement(ctx: ParenthesizedStatementContext): Node {
        return super.visitParenthesizedStatement(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitStatements(ctx: StatementsContext): Node {
        return super.visitStatements(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitSkipStatement(ctx: SkipStatementContext): Node {
        return super.visitSkipStatement(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitAssignmentStatement(ctx: AssignmentStatementContext): Node {
        return super.visitAssignmentStatement(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitIfStatement(ctx: IfStatementContext): Node {
        return super.visitIfStatement(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitWhileStatement(ctx: WhileStatementContext): Node {
        return super.visitWhileStatement(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitCallStatement(ctx: CallStatementContext): Node {
        return super.visitCallStatement(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitArithmeticExpressionList(ctx: ArithmeticExpressionListContext): Node {
        return super.visitArithmeticExpressionList(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitParenthesizedArithmeticExpression(ctx: ParenthesizedArithmeticExpressionContext): Node {
        return super.visitParenthesizedArithmeticExpression(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitMulDivArithmeticExpression(ctx: MulDivArithmeticExpressionContext): Node {
        return super.visitMulDivArithmeticExpression(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitConstantArithmeticExpression(ctx: ConstantArithmeticExpressionContext): Node {
        return super.visitConstantArithmeticExpression(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitIdentifierArithmeticExpression(ctx: IdentifierArithmeticExpressionContext): Node {
        return super.visitIdentifierArithmeticExpression(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitAddSubArithmeticExpression(ctx: AddSubArithmeticExpressionContext): Node {
        return super.visitAddSubArithmeticExpression(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitNegationArithmeticExpression(ctx: NegationArithmeticExpressionContext): Node {
        return super.visitNegationArithmeticExpression(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitBooleanValueBooleanExpression(ctx: BooleanValueBooleanExpressionContext): Node {
        return super.visitBooleanValueBooleanExpression(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitComparitionBooleanExpression(ctx: ComparitionBooleanExpressionContext): Node {
        return super.visitComparitionBooleanExpression(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitNegationBooleanExpression(ctx: NegationBooleanExpressionContext): Node {
        return super.visitNegationBooleanExpression(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitParenthesizedBooleanExpression(ctx: ParenthesizedBooleanExpressionContext): Node {
        return super.visitParenthesizedBooleanExpression(ctx)!!
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    fun visitIdentifier(ctx: WhileParser.IdentifierContext?): Node {
        return super.visitIdentifier(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     *
     * @param ctx
     */
    override fun visitConstant(ctx: ConstantContext): Node {
        return super.visitConstant(ctx)!!
    }

    companion object {
        private fun position(ctx: ParserRuleContext): Position {
            return Position(
                ctx.start.line,
                ctx.start.charPositionInLine
            )
        }
    }
}