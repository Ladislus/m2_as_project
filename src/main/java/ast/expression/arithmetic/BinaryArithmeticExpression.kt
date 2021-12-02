package ast.expression.arithmetic

import ast.Position
import visitor.IVisitor

class BinaryArithmeticExpression(
        position: Position,
        val _leftExpression: ArithmeticExpression,
        val _operator: BinaryArithmeticOperator,
        val _rightExpression: ArithmeticExpression
        ) : ArithmeticExpression(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}