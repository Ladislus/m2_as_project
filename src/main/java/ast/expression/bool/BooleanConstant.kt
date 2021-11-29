package ast.expression.bool

import ast.Node
import ast.Position

class BooleanConstant(
    position: Position,
    val _value: Boolean
    ): Node(position)