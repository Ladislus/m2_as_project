package ast.statement

import ast.Block
import ast.Position
import ast.expression.bool.BooleanExpression

class IfStatement(
        position: Position,
        val _condition: BooleanExpression,
        val _thenBody: Block,
        val _elseBody: Block?
        ): Statement(position)