package ast.statement

import ast.Position
import ast.expression.arithmetic.ArithmeticExpression
import visitor.IVisitor

class AssignStatement(
        position: Position,
        val _variableName: String,
        val _value: ArithmeticExpression
        ) : Statement(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}