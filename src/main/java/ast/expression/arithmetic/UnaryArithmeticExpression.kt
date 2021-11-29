package ast.expression.arithmetic

import ast.Position

class UnaryArithmeticExpression(
        position: Position,
        val _expression: ArithmeticExpression,
        val _operator: UnaryArithmeticOperator = UnaryArithmeticOperator.MINUS
        ) : ArithmeticExpression(position)