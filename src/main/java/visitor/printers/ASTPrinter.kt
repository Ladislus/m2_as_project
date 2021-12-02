package visitor.printers

import ast.*
import ast.declaration.Variable
import ast.declaration.VariableBlock
import ast.expression.arithmetic.ArithmeticConstant
import ast.expression.arithmetic.BinaryArithmeticExpression
import ast.expression.arithmetic.IdentifierExpression
import ast.expression.arithmetic.UnaryArithmeticExpression
import ast.expression.bool.BinaryBooleanExpression
import ast.expression.bool.BooleanConstant
import ast.expression.bool.UnaryBooleanExpression
import ast.statement.*
import visitor.DefaultVisitor

class ASTPrinter: DefaultVisitor<String>() {

    override fun visit(program: Program): String {
        TODO("Not yet implemented")
    }

    override fun visit(procedure: Procedure): String {
        TODO("Not yet implemented")
    }

    override fun visit(type: Type): String {
        TODO("Not yet implemented")
    }

    override fun visit(position: Position): String {
        TODO("Not yet implemented")
    }

    override fun visit(block: Block): String {
        TODO("Not yet implemented")
    }

    override fun visit(variable: Variable): String {
        TODO("Not yet implemented")
    }

    override fun visit(variableBlock: VariableBlock): String {
        TODO("Not yet implemented")
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression): String {
        TODO("Not yet implemented")
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression): String {
        TODO("Not yet implemented")
    }

    override fun visit(arithmeticConstant: ArithmeticConstant): String {
        TODO("Not yet implemented")
    }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression): String {
        TODO("Not yet implemented")
    }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression): String {
        TODO("Not yet implemented")
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression): String {
        TODO("Not yet implemented")
    }

    override fun visit(booleanConstant: BooleanConstant): String {
        TODO("Not yet implemented")
    }

    override fun visit(assignStatement: AssignStatement): String {
        TODO("Not yet implemented")
    }

    override fun visit(callStatement: CallStatement): String {
        TODO("Not yet implemented")
    }

    override fun visit(ifStatement: IfStatement): String {
        TODO("Not yet implemented")
    }

    override fun visit(skipStatement: SkipStatement): String {
        TODO("Not yet implemented")
    }

    override fun visit(whileStatement: WhileStatement): String {
        TODO("Not yet implemented")
    }
}