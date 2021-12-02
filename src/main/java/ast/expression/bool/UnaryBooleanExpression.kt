package ast.expression.bool

import ast.Position
import visitor.IVisitor

class UnaryBooleanExpression(
        position: Position,
        val _expression: BooleanExpression,
        val _operator: UnaryBooleanOperator = UnaryBooleanOperator.NOT,
        ) : BooleanExpression(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}