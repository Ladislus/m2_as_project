package visitor.analyse

import ast.*
import ast.expression.*
import ast.expression.arithmetic.ArithmeticConstant
import ast.expression.bool.BooleanConstant
import ast.statement.*
import visitor.DefaultVisitor
import visitor.flow.Flow
import visitor.flow.IFlow

abstract class DefaultVisitorAnalyse(
    _program: Program,
    ): DefaultVisitor<Unit>() {

    protected val _flow: IFlow = Flow(_program)
    protected val _memory: MutableSet<Expression> = mutableSetOf()

    override fun visit(procedure: Procedure)  {}

    override fun visit(type: Type) {}

    override fun visit(position: Position) {}

    override fun visit(block: Block) {}

    override fun visit(arithmeticConstant: ArithmeticConstant) {}

    override fun visit(booleanConstant: BooleanConstant) {}

    override fun visit(callStatement: CallStatement) {}

    override fun visit(ifStatement: IfStatement) {}

    override fun visit(skipStatement: SkipStatement) {}

    override fun visit(whileStatement: WhileStatement) {}
}