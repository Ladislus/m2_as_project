package visitor.analyse.availableExpressions

import ast.expression.Expression
import ast.expression.arithmetic.ArithmeticConstant
import ast.expression.arithmetic.BinaryArithmeticExpression
import ast.expression.arithmetic.IdentifierExpression
import ast.expression.arithmetic.UnaryArithmeticExpression
import ast.expression.bool.BinaryBooleanExpression
import ast.expression.bool.BooleanConstant
import ast.expression.bool.UnaryBooleanExpression
import visitor.analyse.DefaultKiller

class AvailableExpressionsKiller(
    private val _identifier: String
): DefaultKiller<Set<Expression>?>() {

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression): Set<Expression>? {
        val subcall = unaryArithmeticExpression._expression.accept(this)
        return subcall?.let { it + setOf(unaryArithmeticExpression) }
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression): Set<Expression>? {
        val subcallLeft = binaryArithmeticExpression._leftExpression.accept(this)
        val subcallRight = binaryArithmeticExpression._rightExpression.accept(this)

        return if (subcallLeft != null || subcallRight != null) {
            (subcallLeft ?: setOf()) + (subcallRight ?: setOf()) + setOf(binaryArithmeticExpression)
        } else null
    }

    override fun visit(arithmeticConstant: ArithmeticConstant): Set<Expression>? {
        return null
    }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression): Set<Expression>? {
        // If the identifier expression is the identifier we're looking for, return an emptySet instead
        // of null to propagate the information that the base Expression contains the identifier
        return if (arithmeticIdentifierExpression._identifier == this._identifier) {
            emptySet()
        } else {
            null
        }
    }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression): Set<Expression>? {
        val subcall = unaryBooleanExpression._expression.accept(this)
        return subcall?.let { it + setOf(unaryBooleanExpression) }
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression): Set<Expression>? {
        val subcallLeft = binaryBooleanExpression._leftExpression.accept(this)
        val subcallRight = binaryBooleanExpression._rightExpression.accept(this)

        return if (subcallLeft != null || subcallRight != null) {
            (subcallLeft ?: setOf()) + (subcallRight ?: setOf()) + setOf(binaryBooleanExpression)
        } else null
    }

    override fun visit(booleanConstant: BooleanConstant): Set<Expression>? {
        return null
    }
}