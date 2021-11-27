package ast

import ast.statement.Statement

class Block(
    position: Position,
    val _statements: List<Statement>
    ): Node(position)