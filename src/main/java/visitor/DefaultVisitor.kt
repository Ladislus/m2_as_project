package visitor

import ast.Node
import ast.expression.Expression
import ast.expression.arithmetic.ArithmeticExpression
import ast.expression.bool.BooleanExpression
import ast.statement.Statement

abstract class DefaultVisitor<T> : Visitor<T> {
    override fun visit(node: Node): T =
        raiseIllegalStateExceptionWithClass(node::class)

    override fun visit(expression: Expression): T =
        raiseIllegalStateExceptionWithClass(expression::class)

    override fun visit(arithmeticExpression: ArithmeticExpression): T =
        raiseIllegalStateExceptionWithClass(arithmeticExpression::class)

    override fun visit(booleanExpression: BooleanExpression): T =
        raiseIllegalStateExceptionWithClass(booleanExpression::class)

    override fun visit(statement: Statement): T =
        raiseIllegalStateExceptionWithClass(statement::class)
}