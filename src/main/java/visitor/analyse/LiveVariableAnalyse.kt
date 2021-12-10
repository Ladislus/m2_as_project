package visitor.analyse

import ast.Block
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

abstract class LiveVariableAnalyse(
    _program: Program
) : DefaultVisitorAnalyse(_program) {
    // TODO("not implemented")
}