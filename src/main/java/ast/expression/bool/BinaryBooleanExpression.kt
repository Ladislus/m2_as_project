package ast.expression.bool

import ast.Position
import ast.expression.arithmetic.ArithmeticExpression
import visitor.IVisitor

class BinaryBooleanExpression(
        position: Position,
        val _leftExpression: ArithmeticExpression,
        val _operator: BinaryBooleanOperator,
        val _rightExpression: ArithmeticExpression
        ) : BooleanExpression(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}