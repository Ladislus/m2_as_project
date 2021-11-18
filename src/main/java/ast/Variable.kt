package ast

import ast.expression.Expression


class Variable(
        position: Position,
        val _type: Type,
        val _name: String,
        val _expression: Expression?
        ) : Node(position)