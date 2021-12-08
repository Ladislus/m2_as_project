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

    override fun visit(procedure: Procedure)  {}

    override fun visit(type: Type) {}

    override fun visit(position: Position) {}

    override fun visit(block: Block) {}

    override fun visit(variable: Variable) {}

    override fun visit(variableBlock: VariableBlock) {}

    override fun visit(callStatement: CallStatement) {}

    override fun visit(ifStatement: IfStatement) {}

    override fun visit(skipStatement: SkipStatement) {}

    override fun visit(whileStatement: WhileStatement) {}
}