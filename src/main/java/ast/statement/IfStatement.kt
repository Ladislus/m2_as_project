package ast.statement

import ast.Block
import ast.Position
import ast.expression.bool.BooleanExpression
import visitor.IVisitor

class IfStatement(
        position: Position,
        val _condition: BooleanExpression,
        val _thenBody: Block,
        val _elseBody: Block?
        ): Statement(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}