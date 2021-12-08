package visitor.analyse

import ast.Program
import ast.expression.arithmetic.ArithmeticConstant
import ast.expression.arithmetic.BinaryArithmeticExpression
import ast.expression.arithmetic.IdentifierExpression
import ast.expression.arithmetic.UnaryArithmeticExpression
import ast.expression.bool.BinaryBooleanExpression
import ast.expression.bool.BooleanConstant
import ast.expression.bool.UnaryBooleanExpression
import ast.statement.AssignStatement
import java.beans.Expression

class AvailableExpressionsAnalyse(
    _program: Program
) : DefaultVisitorAnalyse(_program) {

    private val availableExpressions : Set<Expression>  = mutableSetOf()

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) {
        this.availableExpressions.plus(unaryArithmeticExpression)
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) {
        this.availableExpressions.plus(binaryArithmeticExpression)
    }

    override fun visit(arithmeticConstant: ArithmeticConstant) {
        this.availableExpressions.plus(arithmeticConstant)
    }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression) {
        this.availableExpressions.plus(arithmeticIdentifierExpression)
    }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression) {
        this.availableExpressions.plus(unaryBooleanExpression)
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression) {
        this.availableExpressions.plus(binaryBooleanExpression)
    }

    override fun visit(booleanConstant: BooleanConstant) {
        this.availableExpressions.plus(booleanConstant)
    }

    override fun visit(assignStatement: AssignStatement) {
        val idenfier = assignStatement._variableName
        for (expression in this.availableExpressions) {
            kill(expression)
        }
    }
    private fun kill (expression: Expression) {
        val list = ArrayDeque(listOf(expression))
        while (list.isNotEmpty()){
            val current = list.removeFirst()
            when(current){
                is ArithmeticConstant -> {
                    this.availableExpressions.remove(current)
                }
            }

        }
    }
}