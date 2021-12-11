package ast.expression.arithmetic

import ast.Position
import visitor.IVisitor

class IdentifierExpression(
        position: Position,
        val _identifier: String
): ArithmeticExpression(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
    override fun equals(other: Any?): Boolean =
        other is IdentifierExpression &&
        this._identifier == other._identifier

    override fun hashCode(): Int =
        this._identifier.hashCode()
}