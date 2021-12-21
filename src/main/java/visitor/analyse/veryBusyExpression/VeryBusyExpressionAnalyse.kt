package visitor.analyse.veryBusyExpression

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
import visitor.analyse.availableExpressions.AvailableExpressionsKiller
import visitor.flow.IFlow
import visitor.flow.State
import visitor.printers.Printer

class VeryBusyExpressionAnalyse(
    _flow: IFlow
): DefaultAnalyse<Boolean?>(_flow) {

    private val _memory: MutableMap<State, MutableSet<Expression>> = mutableMapOf()
    private val _printer: Printer = Printer()

    private lateinit var _currentState: State
    private lateinit var _currentMemory: MutableSet<Expression>

    override fun analyse() {
        // While we have state in the process stack
        while (this._flow.hasNext()) {
            // Get current state
            this._currentState = this._flow.getNext()
            // Reset the value of the attribute (prevent everybody from having the same memory)
            this._currentMemory = mutableSetOf()

            // Joint of the kill-gen of all the predecessors
            var predecessorsKillGen: Set<Expression>? = null
            this._currentState._predecessors.forEach { currentPredecessor ->
                // If the predecessor is bottom, skip it
                if (this._memory.containsKey(currentPredecessor)) {
                    // Retrieve the memory of the predecessor
                    this._currentMemory = this._memory[currentPredecessor]?.toMutableSet() ?: mutableSetOf()
                    // KillGen of the predecessor
                    currentPredecessor._node.accept(this)

                    // Add it to the joint of all the predecessor's KillGen
                    predecessorsKillGen = predecessorsKillGen?.intersect(this._currentMemory) ?: this._currentMemory
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
                val newMem = this._currentMemory.intersect(previousMem)

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
        println("Very busy expressions at entry:")
        this._memory.toSortedMap { o1, o2 -> o1._index.compareTo(o2._index) }.forEach { (k: State, v: MutableSet<Expression>) ->
            when (k._node) {
                is Program -> {} //println("\tState ${k._index} (Program ${k._node._identifier ?: "?"}): ${v.joinToString(separator = ", ", prefix = "[ ", postfix = " ]") { it.accept(this._printer) }}")
                is Procedure -> {} //println("\tState ${k._index} (Procedure ${k._node._name}): ${v.joinToString(separator = ", ", prefix = "[ ", postfix = " ]") { it.accept(this._printer) }}")
                else -> println("\tState ${k._index} (\"${k._node.accept(this._printer)}\"): ${v.joinToString(separator = ", ", prefix = "[ ", postfix = " ]") { it.accept(this._printer) }}")
            }
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

    override fun visit(procedure: Procedure): Boolean? { return null }


    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression): Boolean {
        val leftEval = binaryArithmeticExpression._leftExpression.accept(this)
        val rightEval = binaryArithmeticExpression._rightExpression.accept(this)
        if ((leftEval == true) || (rightEval == true)) {
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
            this._currentMemory.add(binaryBooleanExpression)
            return true
        }
        return false
    }

    override fun visit(program: Program): Boolean? { return null }

    override fun visit(block: Block): Boolean? { return null }

    override fun visit(variable: Variable): Boolean? { return null }

    override fun visit(variableBlock: VariableBlock): Boolean? { return null }

    override fun visit(assignStatement: AssignStatement): Boolean? {
        // KILL
        val toDestroy = mutableSetOf<Expression>()

        // Retrieve all expressions to kill
        this._currentMemory.forEach { expression ->
            expression.accept(VeryBusyExpressionsKiller(assignStatement._variableName))?.forEach { foundExpression ->
                toDestroy += foundExpression
            }
        }
        // Remove expression to kill from the memory
        // Can't do it in one go as we would remove elements from
        // the memory we are iterating over
        for (expression in toDestroy) {
            this._currentMemory.remove(expression)
        }

        // GEN
        assignStatement._value.accept(this)

        // Return useless value
        return null
    }

    override fun visit(type: Type): Boolean? { return null }

    override fun visit(position: Position): Boolean? { return null }

    override fun visit(arithmeticConstant: ArithmeticConstant): Boolean { return false }

    override fun visit(booleanConstant: BooleanConstant): Boolean { return false }

    override fun visit(callStatement: CallStatement): Boolean? { return null }

    override fun visit(ifStatement: IfStatement): Boolean? { return null }

    override fun visit(skipStatement: SkipStatement): Boolean? { return null }

    override fun visit(whileStatement: WhileStatement): Boolean? { return null }
}