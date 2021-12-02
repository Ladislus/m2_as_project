package ast.declaration

import ast.Position
import ast.Type
import ast.expression.Expression
import visitor.IVisitor

class Variable(
        position: Position,
        val _type: Type,
        val _name: String,
        val _expression: Expression? = null
        ) : Declaration(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}