package ast.statement

import ast.Position
import ast.expression.arithmetic.ArithmeticExpression
import visitor.IVisitor

class CallStatement(
        position: Position,
        val _procedureName: String,
        val _arguments: List<ArithmeticExpression>
        ): Statement(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}