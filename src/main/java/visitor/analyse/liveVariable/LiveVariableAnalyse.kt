package visitor.analyse.liveVariable

import ast.*
import ast.declaration.Variable
import ast.declaration.VariableBlock
import ast.expression.Expression
import ast.expression.arithmetic.ArithmeticConstant
import ast.expression.arithmetic.BinaryArithmeticExpression
import ast.expression.arithmetic.IdentifierExpression
import ast.expression.arithmetic.UnaryArithmeticExpression
import ast.expression.bool.BinaryBooleanExpression
import ast.expression.bool.BooleanConstant
import ast.expression.bool.UnaryBooleanExpression
import ast.statement.*
import visitor.analyse.DefaultAnalyse
import visitor.flow.IFlow
import visitor.flow.State
import visitor.printers.Printer

class LiveVariableAnalyse(
    _flow: IFlow
): DefaultAnalyse<Unit>(_flow, Unit) {

    private val _memory: MutableMap<State, MutableSet<String>> = mutableMapOf()
    private val _printer: Printer = Printer()

    private lateinit var _currentState: State
    private lateinit var _currentMemory: MutableSet<String>

    override fun analyse() {
        // While we have state in the process stack
        while (this._flow.hasNext()) {
            // Get current state
            this._currentState = this._flow.getNext()
            // Reset the value of the attribute (prevent everybody from having the same memory)
            this._currentMemory = mutableSetOf()

            // Joint of the kill-gen of all the predecessors
            var predecessorsKillGen: Set<String>? = null
            this._currentState._predecessors.forEach { currentPredecessor ->
                // If the predecessor is bottom, skip it
                if (this._memory.containsKey(currentPredecessor)) {
                    // Retrieve the memory of the predecessor
                    this._currentMemory = this._memory[currentPredecessor]?.toMutableSet() ?: mutableSetOf()
                    // KillGen of the predecessor
                    currentPredecessor._node.accept(this)

                    // Add it to the joint of all the predecessor's KillGen
                    predecessorsKillGen = predecessorsKillGen?.union(this._currentMemory) ?: this._currentMemory
                }
            }
            if (predecessorsKillGen == null) predecessorsKillGen = mutableSetOf()
            this._currentMemory = predecessorsKillGen?.toMutableSet() ?: mutableSetOf()

            // If the previous memory is bottom (first time we analyse this state) ...
            if (!this._memory.containsKey(this._currentState)) {
                // Update the state's memory
                this._memory[this._currentState] = this._currentMemory.toMutableSet()
                // Add all of its successors to the process stack
                this._flow.pileSuccessors(this._currentState)
            }
            // Else
            else {
                // Compare the previous memory with the new one
                val previousMem = this._memory[this._currentState]!!
                val newMem = this._currentMemory.union(previousMem)

                // If they are different (the two contains are equivalents, but we're never too sure)
                if ((newMem.size != previousMem.size) ||
                    !newMem.containsAll(previousMem) ||
                    !previousMem.containsAll(newMem)
                ) {
                    // Add all of its successors to the process stack
                    this._flow.pileSuccessors(this._currentState)
                    // Update its memory
                    this._memory[this._currentState] = newMem.toMutableSet()
                }
            }
        }

        // Print the memory
        println("Live variables at entry:")
        this._memory.toSortedMap { o1, o2 -> o1._index.compareTo(o2._index) }.forEach { (k: State, v: MutableSet<String>) ->
            when (k._node) {
                is Program -> {} //println("\tState ${k._index} (Program ${k._node._identifier ?: "?"}): ${v.joinToString(separator = ", ", prefix = "[ ", postfix = " ]") { it }}")
                is Procedure -> {} //println("\tState ${k._index} (Procedure ${k._node._name}): ${v.joinToString(separator = ", ", prefix = "[ ", postfix = " ]") { it }}")
                else -> println("\tState ${k._index} (\"${k._node.accept(this._printer)}\"): ${v.joinToString(separator = ", ", prefix = "[ ", postfix = " ]") { it }}")
            }
        }
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) {
        unaryArithmeticExpression._expression.accept(this)
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) {
        binaryArithmeticExpression._leftExpression.accept(this)
        binaryArithmeticExpression._rightExpression.accept(this)
    }

    override fun visit(arithmeticConstant: ArithmeticConstant) {}

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression) {
        this._currentMemory += arithmeticIdentifierExpression._identifier
    }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression) {
        unaryBooleanExpression._expression.accept(this)
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression) {
        binaryBooleanExpression._leftExpression.accept(this)
        binaryBooleanExpression._rightExpression.accept(this)
    }

    override fun visit(booleanConstant: BooleanConstant) {}

    override fun visit(assignStatement: AssignStatement) {
        // KILL
        this._currentMemory -= assignStatement._variableName
        // GEN
        assignStatement._value.accept(this)
    }
}