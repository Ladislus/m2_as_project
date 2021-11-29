package ast.statement

import ast.Block
import ast.Position
import ast.expression.bool.BooleanExpression

class WhileStatement(
        position: Position,
        val _condition: BooleanExpression,
        val _body: Block
        ): Statement(position)