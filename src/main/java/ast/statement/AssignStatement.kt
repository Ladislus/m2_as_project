package ast.statement

import ast.Position
import ast.expression.arithmetic.ArithmeticExpression

class AssignStatement(
        position: Position,
        val _variableName: String,
        val _value: ArithmeticExpression
        ) : Statement(position)