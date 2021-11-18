package ast.expression.bool

import ast.Position

class UnaryBooleanExpression(
        position: Position,
        val _expression: BooleanExpression,
        val _operator: BooleanOperator,
        ) : BooleanExpression(position)