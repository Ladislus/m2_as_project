package ast.expression.arithmetic

import ast.Position

class ArithmeticConstant(
    position: Position,
    val _value: Int
    ): ArithmeticExpression(position)