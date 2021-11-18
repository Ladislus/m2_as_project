package ast.expression.bool

import ast.Position

class BinaryBooleanExpression(
        position: Position,
        val _leftExpression: BooleanExpression,
        val _operator: BooleanOperator,
        val _rightExpression: BooleanExpression
        ) : BooleanExpression(position)