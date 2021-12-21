package visitor.analyse

import ast.*
import ast.declaration.Variable
import ast.declaration.VariableBlock
import ast.statement.CallStatement
import ast.statement.IfStatement
import ast.statement.SkipStatement
import ast.statement.WhileStatement
import visitor.DefaultVisitor
import visitor.flow.IFlow

abstract class DefaultAnalyse<T>(
    protected val _flow: IFlow,
    private val _defaultValue: T
): IAnalyse, DefaultVisitor<T>() {
    override fun visit(program: Program): T =
        this._defaultValue

    override fun visit(procedure: Procedure): T =
        this._defaultValue

    override fun visit(type: Type): T =
        this._defaultValue

    override fun visit(position: Position): T =
        this._defaultValue

    override fun visit(block: Block): T =
        this._defaultValue

    override fun visit(variable: Variable): T =
        this._defaultValue

    override fun visit(variableBlock: VariableBlock): T =
        this._defaultValue

    override fun visit(callStatement: CallStatement): T =
        this._defaultValue

    override fun visit(ifStatement: IfStatement): T =
        this._defaultValue

    override fun visit(skipStatement: SkipStatement): T =
        this._defaultValue

    override fun visit(whileStatement: WhileStatement): T =
        this._defaultValue
}