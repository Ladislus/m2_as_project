package visitor.analyse

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

abstract class DefaultVisitorAnalyse: DefaultVisitor<Node>() {

    override fun visit(program: Program): Node {
        TODO("Not yet implemented")
    }

    override fun visit(procedure: Procedure): Node {
        TODO("Not yet implemented")
    }

    override fun visit(type: Type): Node {
        TODO("Not yet implemented")
    }

    override fun visit(position: Position): Node {
        TODO("Not yet implemented")
    }

    override fun visit(block: Block): Node {
        TODO("Not yet implemented")
    }

    override fun visit(variable: Variable): Node {
        TODO("Not yet implemented")
    }

    override fun visit(variableBlock: VariableBlock): Node {
        TODO("Not yet implemented")
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression): Node {
        TODO("Not yet implemented")
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression): Node {
        TODO("Not yet implemented")
    }

    override fun visit(arithmeticConstant: ArithmeticConstant): Node {
        TODO("Not yet implemented")
    }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression): Node {
        TODO("Not yet implemented")
    }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression): Node {
        TODO("Not yet implemented")
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression): Node {
        TODO("Not yet implemented")
    }

    override fun visit(booleanConstant: BooleanConstant): Node {
        TODO("Not yet implemented")
    }

    override fun visit(assignStatement: AssignStatement): Node {
        TODO("Not yet implemented")
    }

    override fun visit(callStatement: CallStatement): Node {
        TODO("Not yet implemented")
    }

    override fun visit(ifStatement: IfStatement): Node {
        TODO("Not yet implemented")
    }

    override fun visit(skipStatement: SkipStatement): Node {
        TODO("Not yet implemented")
    }

    override fun visit(whileStatement: WhileStatement): Node {
        TODO("Not yet implemented")
    }
}