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

class VeryBusyExpressionAnalyse(
    _program: Program
) : DefaultVisitorAnalyse(_program) {

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) {
        TODO("Not yet implemented")
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) {
        TODO("Not yet implemented")
    }

    override fun visit(arithmeticConstant: ArithmeticConstant) {
        TODO("Not yet implemented")
    }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression) {
        TODO("Not yet implemented")
    }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression) {
        TODO("Not yet implemented")
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression) {
        TODO("Not yet implemented")
    }

    override fun visit(booleanConstant: BooleanConstant) {
        TODO("Not yet implemented")
    }

    override fun visit(assignStatement: AssignStatement) {
        TODO("Not yet implemented")
    }

}