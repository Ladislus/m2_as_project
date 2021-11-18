package ast

import ast.statement.Statement

class Procedure(
        position: Position,
        val _name: String,
        val _variables: List<Variable>,
        val _returnType: Type?,
        val _returnIdentifier: String?,
        val _statements: List<Statement>
        ) : Node(position)