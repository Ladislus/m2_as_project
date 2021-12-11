package ast.expression.bool

import ast.Node
import ast.Position
import visitor.IVisitor

class BooleanConstant(
        position: Position,
        val _value: Boolean
): Node(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
    override fun equals(other: Any?): Boolean =
        other is BooleanConstant &&
        other._value == this._value

    override fun hashCode(): Int =
        this._value.hashCode()
}