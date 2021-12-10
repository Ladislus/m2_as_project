package visitor.analyse

import ast.Block
import ast.Program
import ast.declaration.Variable
import ast.declaration.VariableBlock
import ast.expression.arithmetic.BinaryArithmeticExpression
import ast.expression.arithmetic.IdentifierExpression
import ast.expression.arithmetic.UnaryArithmeticExpression
import ast.expression.bool.BinaryBooleanExpression
import ast.expression.bool.UnaryBooleanExpression
import ast.statement.AssignStatement
import visitor.flow.Flow
import visitor.flow.IFlow

class AvailableExpressionsAnalyse(
    _flow: IFlow
    ): DefaultAnalyse(_flow) {

    private var _hasChanged: Boolean = false

    override fun analyse() {
        while (this._flow.hasNext()) {
            val currentState = this._flow.getNext()
            currentState._node.accept(this)
            if (this._hasChanged) {
                this._flow.pileSuccessors(currentState)
                this._hasChanged = false
            }
        }
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression): Boolean {
        if (unaryArithmeticExpression.accept(this) == true) {
            this._hasChanged = this._memory.add(unaryArithmeticExpression)
            return true
        }
        return false
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression): Boolean {
        var status = false
        if (binaryArithmeticExpression._leftExpression.accept(this) == true) {
            status = true
            this._hasChanged = this._memory.add(binaryArithmeticExpression)
        }
        if (binaryArithmeticExpression._rightExpression.accept(this) == true) {
            status = true
            this._hasChanged = this._memory.add(binaryArithmeticExpression)
        }
        return status
    }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression): Boolean {
        return true
    }


    override fun visit(unaryBooleanExpression: UnaryBooleanExpression): Boolean {
        if (unaryBooleanExpression.accept(this) == true) {
            this._hasChanged = this._memory.add(unaryBooleanExpression)
            return true
        }
        return false
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression): Boolean {
        var status = false
        if (binaryBooleanExpression._leftExpression.accept(this) == true) {
            status = true
            this._hasChanged = this._memory.add(binaryBooleanExpression)
        }
        if (binaryBooleanExpression._rightExpression.accept(this) == true) {
            status = true
            this._hasChanged = this._memory.add(binaryBooleanExpression)
        }
        return status
    }

    override fun visit(program: Program): Boolean? {
        // Visit all variables (they can contain expressions) & statements
        program._variables.forEach { it.accept(this) }
        program._statements.forEach { it.accept(this) }
        return null
    }

    override fun visit(block: Block): Boolean? {
        // Propagate the visit to all statements
        block._statements.forEach { it.accept(this) }
        return null
    }

    override fun visit(variable: Variable): Boolean? {
        // Variable can contains expressions
        variable._expression?.accept(this)
        return null
    }

    override fun visit(variableBlock: VariableBlock): Boolean? {
        // Variable can contains expressions
        variableBlock._variables.forEach { it.accept(this) }
        return null
    }

    override fun visit(assignStatement: AssignStatement): Boolean? {
        val identifier = assignStatement._variableName

        for (expression in this._memory) {
            // TODO Kill
        }

        return null
    }
}