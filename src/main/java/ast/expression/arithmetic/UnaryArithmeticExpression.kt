package ast.expression.arithmetic

import ast.Position
import visitor.IVisitor

class UnaryArithmeticExpression(
        position: Position,
        val _expression: ArithmeticExpression,
        val _operator: UnaryArithmeticOperator = UnaryArithmeticOperator.MINUS
) : ArithmeticExpression(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
    override fun equals(other: Any?): Boolean =
        other is UnaryArithmeticExpression &&
        this._expression == other._expression &&
        this._operator == other._operator

    override fun hashCode(): Int =
        (31 * this._expression.hashCode()) + this._operator.hashCode()
}