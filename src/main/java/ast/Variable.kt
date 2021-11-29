package ast

import ast.expression.Expression


open class Variable(
        position: Position,
        val _type: Type,
        val _name: String,
        val _expression: Expression? = null
        ) : Node(position)