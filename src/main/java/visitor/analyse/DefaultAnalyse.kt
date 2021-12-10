package visitor.analyse

import ast.*
import ast.expression.*
import ast.expression.arithmetic.ArithmeticConstant
import ast.expression.bool.BooleanConstant
import ast.statement.*
import visitor.DefaultVisitor
import visitor.flow.Flow
import visitor.flow.IFlow

abstract class DefaultAnalyse(
    protected val _flow: IFlow
    ): IAnalyse, DefaultVisitor<Boolean?>() {

    protected val _memory: MutableSet<Expression> = mutableSetOf()

    override fun visit(procedure: Procedure): Boolean? { return null }

    override fun visit(type: Type): Boolean? { return null }

    override fun visit(position: Position): Boolean? { return null }

    override fun visit(arithmeticConstant: ArithmeticConstant): Boolean { return false }

    override fun visit(booleanConstant: BooleanConstant): Boolean { return false }

    override fun visit(callStatement: CallStatement): Boolean? { return null }

    override fun visit(ifStatement: IfStatement): Boolean? { return null }

    override fun visit(skipStatement: SkipStatement): Boolean? { return null }

    override fun visit(whileStatement: WhileStatement): Boolean? { return null }
}