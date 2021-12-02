package ast.expression.bool

import ast.Node
import ast.Position
import visitor.IVisitor

class BooleanConstant(
        position: Position,
        val _value: Boolean
        ): Node(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}