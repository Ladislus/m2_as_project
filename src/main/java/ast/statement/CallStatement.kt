package ast.statement

import ast.Position
import ast.expression.arithmetic.ArithmeticExpression

class CallStatement(position: Position,
        val _procedureName: String,
        val _arguments: List<ArithmeticExpression>
        ): Statement(position)