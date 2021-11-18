package ast.statement

import ast.Position
import ast.expression.bool.BooleanExpression

class IfStatement(
        position: Position,
        val _condition: BooleanExpression,
        val _thenBody: List<Statement>,
        val _elseBody: List<Statement>?
        ): Statement(position)