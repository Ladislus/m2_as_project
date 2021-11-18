package ast

import ast.statement.Statement

class Program(
        position: Position,
        val _procedures: List<Procedure>,
        val _variables: List<Variable>,
        val _statements: List<Statement>
        ) : Node(position)