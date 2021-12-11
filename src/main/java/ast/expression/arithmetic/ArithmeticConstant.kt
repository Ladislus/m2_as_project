package ast.expression.arithmetic

import ast.Position
import visitor.IVisitor

class ArithmeticConstant(
        position: Position,
        val _value: Int
): ArithmeticExpression(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
    override fun equals(other: Any?): Boolean =
        other is ArithmeticConstant &&
        other._value == this._value

    override fun hashCode(): Int =
        this._value.hashCode()
}