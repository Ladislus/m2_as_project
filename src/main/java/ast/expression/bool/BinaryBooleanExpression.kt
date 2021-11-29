package ast.expression.bool

import ast.Position
import ast.expression.arithmetic.ArithmeticExpression

class BinaryBooleanExpression(
        position: Position,
        val _leftExpression: ArithmeticExpression,
        val _operator: BinaryBooleanOperator,
        val _rightExpression: ArithmeticExpression
        ) : BooleanExpression(position)