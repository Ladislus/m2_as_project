package ast.statement

import ast.Position
import ast.expression.bool.BooleanExpression

class WhileExpression(
        position: Position,
        val _condition: BooleanExpression,
        val _body: List<Statement>
        ): Statement(position)