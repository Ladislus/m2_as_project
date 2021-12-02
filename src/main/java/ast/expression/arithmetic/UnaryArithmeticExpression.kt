package ast.expression.arithmetic

import ast.Position
import visitor.IVisitor

class UnaryArithmeticExpression(
        position: Position,
        val _expression: ArithmeticExpression,
        val _operator: UnaryArithmeticOperator = UnaryArithmeticOperator.MINUS
        ) : ArithmeticExpression(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}