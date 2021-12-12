package ast.expression.arithmetic

import ast.Position
import visitor.IVisitor
import visitor.printers.Printer

class BinaryArithmeticExpression(
        position: Position,
        val _leftExpression: ArithmeticExpression,
        val _operator: BinaryArithmeticOperator,
        val _rightExpression: ArithmeticExpression
) : ArithmeticExpression(position) {
        override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
        override fun equals(other: Any?): Boolean =
                other is BinaryArithmeticExpression &&
                this._operator == other._operator &&
                (
                        (this._leftExpression == other._leftExpression && this._rightExpression == other._rightExpression)
                        ||
                        (this._leftExpression == other._rightExpression && this._rightExpression == other._leftExpression)
                )

        override fun hashCode(): Int =
                (31 * this._leftExpression.hashCode()) + this._operator.hashCode() + (31 * this._rightExpression.hashCode())
}