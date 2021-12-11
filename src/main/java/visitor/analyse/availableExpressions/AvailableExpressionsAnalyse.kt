package visitor.analyse.availableExpressions

import ast.Block
import ast.Procedure
import ast.Program
import ast.declaration.Variable
import ast.declaration.VariableBlock
import ast.expression.Expression
import ast.expression.arithmetic.BinaryArithmeticExpression
import ast.expression.arithmetic.IdentifierExpression
import ast.expression.arithmetic.UnaryArithmeticExpression
import ast.expression.bool.BinaryBooleanExpression
import ast.expression.bool.UnaryBooleanExpression
import ast.statement.AssignStatement
import visitor.analyse.DefaultAnalyse
import visitor.flow.IFlow
import visitor.flow.State
import visitor.printers.Printer

class AvailableExpressionsAnalyse(
    _flow: IFlow
    ): DefaultAnalyse(_flow) {

    private val _memory: MutableMap<State, Pair<MutableSet<Expression>, Boolean>> = mutableMapOf()
    private val _printer: Printer = Printer()

    // TODO("C'est moche mais ça fonctionne)
    private lateinit var _currentState: State
    private lateinit var _currentMemory: MutableSet<Expression>
    private var _hasChanged: Boolean = false

    private fun getPredecessorsMemory(predecessors: Set<State>): Set<Expression> {
        var allPredeccessorsMem: MutableSet<Expression>? = null
        for (predecessor in predecessors) {
            println("\t\t\t\tPredecessor (${predecessor._node.accept(this._printer)}): [${this._memory[predecessor]?.first?.joinToString(", ") { it.accept(this._printer) } ?: ""}]")
            allPredeccessorsMem =
                if (allPredeccessorsMem == null) {
                    this._memory[predecessor]?.first
                } else {
                    (this._memory[predecessor]?.first?.intersect(allPredeccessorsMem) as MutableSet?) ?: allPredeccessorsMem
                }
        }
        return allPredeccessorsMem ?: mutableSetOf()
    }

    override fun analyse() {

        while (this._flow.hasNext()) {
            // Get current state
            this._currentState = this._flow.getNext()
            // Try to retrieve state's memory, or allocate empty if it was never visited
//            this._currentMemory = this._memory[this._currentState]?.first ?: mutableSetOf()
            this._currentMemory = this._memory[this._currentState]?.let { this.getPredecessorsMemory(this._currentState._predecessors) as MutableSet<Expression> } ?: mutableSetOf()

            // TODO("Remove later)
            println("==============================================================================================")
            println("Current state: ${this._currentState}")
            println("Current node: ${this._currentState._node}")
            println("Current node printed: ${this._currentState._node.accept(this._printer)}")
            println("Current mem: [${this._currentMemory.joinToString(separator = ", ") { it.accept(this._printer) }}]")

            val predecessorsMemory = this.getPredecessorsMemory(this._currentState._predecessors)
            println("\tPredecessors mem: [${predecessorsMemory.joinToString(separator = ", ") { it.accept(this._printer) }}]")
            this._currentMemory += (predecessorsMemory) as MutableSet<Expression>
            println("\tCurrent mem plus predecessors: [${this._currentMemory.joinToString(separator = ", ") { it.accept(this._printer) }}]")


            // Launch analysis of the node
            this._currentState._node.accept(this)

            // If the analysis changed something
            if (!this._memory.containsKey(this._currentState) || this._hasChanged) {
                println("\tMemory changed")
                // Test if the new memory is greater than the previous one
                val previousMemory = this._memory[this._currentState]
                println("\tPrevious mem: [${previousMemory?.first?.joinToString(separator = ", ") { it.accept(this._printer) } ?: ""}]")
                if (
                    // If it's the first time we analyse this state
                    previousMemory == null
                    || (
                            // Or if the memory is greater than the previous one
                            this._currentMemory.containsAll(previousMemory.first)
                            && this._currentMemory.size > previousMemory.first.size
                    )
                ) {
                    println("\t\t✓ => Memory is greater than previous one")
                    // Update the memory
                    this._memory[this._currentState] = Pair(this._currentMemory, true)
                    // Pile successors
                    this._flow.pileSuccessors(this._currentState)
                } else {
                    // Else set "changed" flag to false
                    this._memory[this._currentState] = Pair(this._memory[this._currentState]!!.first, false)
                    println("\t\t✗ => Memory is not greater than previous one")
                }
                println("==============================================================================================")
                // Reset global variable
                this._hasChanged = false
            }
        }

        // Print the memory
        println("Available expressions:")
        this._memory.forEach { (k: State, v: Pair<MutableSet<Expression>, Boolean>) ->
            println("\tState${k._index}(${k._node.accept(this._printer)}): ${v.first.joinToString(separator = ", ", prefix = "[ ", postfix = " ]") { it.accept(this._printer) }}")
        }
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression): Boolean {
        if (unaryArithmeticExpression._expression.accept(this) == true) {
            if (this._currentState._node != unaryArithmeticExpression)
                this._hasChanged = this._currentMemory.add(unaryArithmeticExpression)
            return true
        }
        return false
    }

    override fun visit(procedure: Procedure): Boolean? {
        procedure._variables.forEach { it.accept(this) }
        procedure._return?.accept(this)
        procedure._statements.forEach { it.accept(this) }
        return null
    }


    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression): Boolean {
        val leftEval = binaryArithmeticExpression._leftExpression.accept(this)
        val rightEval = binaryArithmeticExpression._rightExpression.accept(this)
        if ((leftEval == true) || (rightEval == true)) {
            if (this._currentState._node != binaryArithmeticExpression)
                this._hasChanged = this._currentMemory.add(binaryArithmeticExpression)
            return true
        }
        return false
    }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression): Boolean {
        return true
    }


    override fun visit(unaryBooleanExpression: UnaryBooleanExpression): Boolean {
        if (unaryBooleanExpression._expression.accept(this) == true) {
            if (this._currentState._node != unaryBooleanExpression)
                this._hasChanged = this._currentMemory.add(unaryBooleanExpression)
            return true
        }
        return false
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression): Boolean {
        val leftEval = binaryBooleanExpression._leftExpression.accept(this)
        val rightEval = binaryBooleanExpression._rightExpression.accept(this)
        if ((leftEval == true) || (rightEval == true)) {
            if (this._currentState._node != binaryBooleanExpression)
                this._hasChanged = this._currentMemory.add(binaryBooleanExpression)
            return true
        }
        return false
    }

    override fun visit(program: Program): Boolean? {
        // Visit all variables (they can contain expressions) & statements
        program._procedures.forEach { it.accept(this) }
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
        // GEN
        assignStatement._value.accept(this)

        // KILL
        println("-------------------------------------------------------------------------------------------------------")
        println("\tBefore destroy: [${this._currentMemory.joinToString(separator = ", ") { it.accept(this._printer) }}]")
        val toDestroy = mutableSetOf<Expression>()
        for (expression in this._currentMemory)
            expression.accept(AvailableExpressionsKiller(assignStatement._variableName))?.let {
                toDestroy += it
            }
        println("\tTo destroy (identifier: ${assignStatement._variableName}): [${toDestroy.joinToString(separator = ", ") { it.accept(this._printer) }}]")
        for (expression in toDestroy) {
            this._currentMemory.remove(expression)
        }
        println("\tAfter destoy: [${this._currentMemory.joinToString(separator = ", ") { it.accept(this._printer) }}]")
        println("-------------------------------------------------------------------------------------------------------")

        return null
    }
}