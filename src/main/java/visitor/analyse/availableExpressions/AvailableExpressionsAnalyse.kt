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

    private val _memory: MutableMap<State, MutableSet<Expression>> = mutableMapOf()
    private val _printer: Printer = Printer()

    // TODO("C'est moche mais ça fonctionne)
    private lateinit var _currentState: State
    private lateinit var _currentMemory: MutableSet<Expression>

    private fun getPredecessorsMemory(predecessors: Set<State>): MutableSet<Expression> {
        // Can't initialise candidate because an empty intersected with anything is the empty set
        // (null represent bottom)
        var candidate: MutableSet<Expression>? = null
        for (predecessor in predecessors) {
            candidate =
                // If the candidate is Bottom...
                if (candidate == null) {
                    // ... we try to set it to the predecessor's memory (which can also be bottom)
                    this._memory[predecessor]
                // If it's not bottom ...
                } else {
                    // ... we try to intersect the two (if it's bottom, we keep the previous value of candidate)
                    (this._memory[predecessor]?.intersect(candidate)?.toMutableSet()) ?: candidate
                }
        }
        // Return the intersection of all predecessors (or an empty set if they all are bottom)
        return candidate ?: mutableSetOf()
    }

    override fun analyse() {
        // While we have state in the process stack
        while (this._flow.hasNext()) {
            // Get current state
            this._currentState = this._flow.getNext()
            // Reset the value of the attribut (prevent everybody from having the same memory)
            this._currentMemory = mutableSetOf()
            // Retrieve predecessors' memory
            this._currentMemory += this.getPredecessorsMemory(this._currentState._predecessors)
            // Launch analysis of the node
            this._currentState._node.accept(this)

            // If the previous memory is bottom (first time we analyse this state) ...
            if (!this._memory.containsKey(this._currentState)) {
                // Update the state's memory
                this._memory[this._currentState] = this._currentMemory
                // Add all of it's sucessors to the process stack
                this._flow.pileSuccessors(this._currentState)
            }
            // Else
            else {
                // Compare the previous memory with the new one
                val previousMem = this._memory[this._currentState]!!
                val newMem = this._currentMemory.intersect(previousMem)
                // If they are different (the two contains are equivalents, but we're never too sure)
                if ((newMem.size != previousMem.size) ||
                    !newMem.containsAll(previousMem) ||
                    !previousMem.containsAll(newMem)
                ) {
                    // Add all of it's sucessors to the process stack
                    this._flow.pileSuccessors(this._currentState)
                    // Update its memory
                    this._memory[this._currentState] = newMem.toMutableSet()
                }
            }
        }

        // Print the memory
        println("Available expressions at exits:")
        this._memory.forEach { (k: State, v: MutableSet<Expression>) ->
            println("\tState ${k._index} (\"${k._node.accept(this._printer)}\"): ${v.joinToString(separator = ", ", prefix = "[ ", postfix = " ]") { it.accept(this._printer) }}")
        }
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression): Boolean {
        if (unaryArithmeticExpression._expression.accept(this) == true) {
            if (this._currentState._node != unaryArithmeticExpression)
                this._currentMemory.add(unaryArithmeticExpression)
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
                this._currentMemory.add(binaryArithmeticExpression)
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
                this._currentMemory.add(unaryBooleanExpression)
            return true
        }
        return false
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression): Boolean {
        val leftEval = binaryBooleanExpression._leftExpression.accept(this)
        val rightEval = binaryBooleanExpression._rightExpression.accept(this)
        if ((leftEval == true) || (rightEval == true)) {
            if (this._currentState._node != binaryBooleanExpression)
                this._currentMemory.add(binaryBooleanExpression)
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
        val toDestroy = mutableSetOf<Expression>()
        // Retrieve all expressions to kill
        this._currentMemory.forEach { expression ->
            expression.accept(AvailableExpressionsKiller(assignStatement._variableName))?.forEach { foundExpression ->
                toDestroy += foundExpression
            }
        }
        // Remove expression to kill from the memory
        // Can't do it in one go as we would remove elements from
        // the memory we are iterating over
        for (expression in toDestroy) {
            this._currentMemory.remove(expression)
        }

        // Return useless value
        return null
    }
}