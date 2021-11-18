package ast.expression.bool

import ast.Position

class BinaryBooleanExpression(
        position: Position,
        val _leftExpression: BooleanExpression,
        val _operator: BinaryBooleanOperator,
        val _rightExpression: BooleanExpression
        ) : BooleanExpression(position)