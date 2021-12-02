package ast

import ast.declaration.Variable
import ast.statement.Statement
import visitor.IVisitor

class Procedure(
        position: Position,
        val _name: String,
        val _variables: List<Variable>,
        val _return: Variable?,
        val _statements: List<Statement>
        ) : Node(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}