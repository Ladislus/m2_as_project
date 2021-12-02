package visitor

import ast.Node
import ast.declaration.Declaration
import ast.expression.Expression
import ast.expression.arithmetic.ArithmeticExpression
import ast.expression.bool.BooleanExpression
import ast.statement.Statement

fun <T> raiseIllegalStateExceptionWithClass(clazz: Class<T>): Nothing =
    throw IllegalStateException("Shouldn't be possible to reach visit(${clazz})")

abstract class DefaultVisitor<T> : IVisitor<T> {
    override fun visit(node: Node): T =
        raiseIllegalStateExceptionWithClass(node::class.java)

    override fun visit(declaration: Declaration): T =
        raiseIllegalStateExceptionWithClass(declaration::class.java)


    override fun visit(expression: Expression): T =
        raiseIllegalStateExceptionWithClass(expression::class.java)

    override fun visit(arithmeticExpression: ArithmeticExpression): T =
        raiseIllegalStateExceptionWithClass(arithmeticExpression::class.java)

    override fun visit(booleanExpression: BooleanExpression): T =
        raiseIllegalStateExceptionWithClass(booleanExpression::class.java)

    override fun visit(statement: Statement): T =
        raiseIllegalStateExceptionWithClass(statement::class.java)
}