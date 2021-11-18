package ast.expression.arithmetic

import ast.Position

class BinaryArithmeticExpression(
        position: Position,
        val _leftExpression: ArithmeticExpression,
        val _operator: ArithmeticOperator,
        val _rightExpression: ArithmeticExpression
        ) : ArithmeticExpression(position)