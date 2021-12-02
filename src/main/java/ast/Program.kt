package ast

import ast.declaration.Declaration
import ast.declaration.Variable
import ast.statement.Statement
import visitor.IVisitor

class Program(
        position: Position,
        val _identifier: String?,
        val _procedures: List<Procedure>,
        val _variables: List<Declaration>,
        val _statements: List<Statement>
        ) : Node(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}