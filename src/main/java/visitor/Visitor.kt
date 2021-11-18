package visitor

import ast.*
import ast.expression.*
import ast.expression.arithmetic.*
import ast.expression.bool.*
import ast.statement.*

interface Visitor<T> {
    fun visit(node: Node): T
    fun visit(program: Program): T
    fun visit(procedure: Procedure): T
    fun visit(type: Type): T
    fun visit(variable: Variable): T
    fun visit(declaration: Declaration): T
    fun visit(expression: Expression): T
    fun visit(arithmeticExpression: ArithmeticExpression): T
    fun visit(unaryArithmeticExpression: UnaryArithmeticExpression): T
    fun visit(binaryArithmeticExpression: BinaryArithmeticExpression): T
    fun visit(booleanExpression: BooleanExpression): T
    fun visit(unaryBooleanExpression: UnaryBooleanExpression): T
    fun visit(binaryBooleanExpression: BinaryBooleanExpression): T
    fun visit(statement: Statement): T
    fun visit(assignStatement: AssignStatement): T
    fun visit(callStatement: CallStatement)
    fun visit(ifStatement: IfStatement): T
    fun visit(skipStatement: SkipStatement): T
    fun visit(whileStatement: WhileStatement): T
}