package visitor.analyse

import ast.Program
import ast.declaration.Variable
import ast.declaration.VariableBlock
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

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) {
        unaryArithmeticExpression.accept(this)
        this._memory.plus(unaryArithmeticExpression)
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) {
        binaryArithmeticExpression._leftExpression.accept(this)
        binaryArithmeticExpression._rightExpression.accept(this)
        this._memory.plus(binaryArithmeticExpression)
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

    override fun visit(program: Program) {
        TODO("Not yet implemented")
    }

    override fun visit(variable: Variable) {
        TODO("Not yet implemented")
    }

    override fun visit(variableBlock: VariableBlock) {
        TODO("Not yet implemented")
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