package ast.expression.arithmetic

import ast.Position

class IdentifierExpression(
        position: Position,
        val _identifier: String
        ): ArithmeticExpression(position)