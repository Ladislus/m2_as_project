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
import visitor.flow.ForwardFlow
import visitor.flow.IFlow

abstract class DefaultVisitorAnalyse(
    private val _program: Program,
    private val _flow: IFlow = ForwardFlow()
    ): DefaultVisitor<Unit>() {

    init {
        this._flow.constructFlow(this._program)
    }

    override fun visit(program: Program) {
        while (this._flow.hasNext()) this._flow.getNext().accept(this)
    }

    override fun visit(procedure: Procedure) {
        TODO("Not yet implemented")
    }

    override fun visit(type: Type) {
        TODO("Not yet implemented")
    }

    override fun visit(position: Position) {
        TODO("Not yet implemented")
    }

    override fun visit(block: Block) {
        TODO("Not yet implemented")
    }

    override fun visit(variable: Variable) {
        TODO("Not yet implemented")
    }

    override fun visit(variableBlock: VariableBlock) {
        TODO("Not yet implemented")
    }

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

    override fun visit(callStatement: CallStatement) {
        TODO("Not yet implemented")
    }

    override fun visit(ifStatement: IfStatement) {
        TODO("Not yet implemented")
    }

    override fun visit(skipStatement: SkipStatement) {
        TODO("Not yet implemented")
    }

    override fun visit(whileStatement: WhileStatement) {
        TODO("Not yet implemented")
    }
}