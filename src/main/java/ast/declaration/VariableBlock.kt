package ast.declaration

import ast.Position
import visitor.IVisitor

class VariableBlock(
        position: Position,
        val _variables: List<Variable>
        ): Declaration(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}