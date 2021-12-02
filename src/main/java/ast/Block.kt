package ast

import ast.statement.Statement
import visitor.IVisitor

class Block(
        position: Position,
        val _statements: List<Statement>
        ): Node(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}