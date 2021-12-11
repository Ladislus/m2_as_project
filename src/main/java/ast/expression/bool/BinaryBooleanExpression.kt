package ast.expression.bool

import ast.Position
import ast.expression.arithmetic.ArithmeticExpression
import visitor.IVisitor

class BinaryBooleanExpression(
        position: Position,
        val _leftExpression: ArithmeticExpression,
        val _operator: BinaryBooleanOperator,
        val _rightExpression: ArithmeticExpression
) : BooleanExpression(position) {
        override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
        override fun equals(other: Any?): Boolean =
                other is BinaryBooleanExpression &&
                this._leftExpression == other._leftExpression &&
                this._operator == other._operator &&
                this._rightExpression == other._rightExpression

        override fun hashCode(): Int =
                (31 * (31 * this._leftExpression.hashCode()) + this._operator.hashCode()) + this._rightExpression.hashCode()
}