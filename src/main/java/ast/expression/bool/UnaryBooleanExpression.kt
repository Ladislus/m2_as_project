package ast.expression.bool

import ast.Position
import visitor.IVisitor

class UnaryBooleanExpression(
        position: Position,
        val _expression: BooleanExpression,
        val _operator: UnaryBooleanOperator = UnaryBooleanOperator.NOT,
) : BooleanExpression(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
    override fun equals(other: Any?): Boolean =
        other is UnaryBooleanExpression &&
                this._expression == other._expression &&
                this._operator == other._operator

    override fun hashCode(): Int =
        (31 * this._expression.hashCode()) + this._operator.hashCode()
}