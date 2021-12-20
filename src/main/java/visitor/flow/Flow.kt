package visitor.flow

import ast.*
import ast.declaration.*
import ast.expression.arithmetic.*
import ast.expression.bool.*
import ast.statement.*
import utils.ExitCode
import utils.exitWithCode
import visitor.printers.Printer

class Flow(
    _program: Program,
    reversed: Boolean,
    private val _printer: Printer = Printer()
    ): DefaultFlow(_program, reversed) {

    private val _cache = mutableMapOf<Node, Pair<State, List<State>>>()

    init {
        val ie = this._program.accept(this)
        this._heads += ie.first
        this._tails += ie.second
        this.initStack()
    }

    override fun visit(program: Program): Pair<State, List<State>> {

        val state = createOrGetExistingState(program, "program ${program._identifier ?: ""}")

        // Visit all procedures
        for (i in 0 until program._procedures.size - 1) {
            val currentProcedureIE = program._procedures[i].accept(this)
            val nextProcedureIE = program._procedures[i + 1].accept(this)

            currentProcedureIE.second.forEach { it.addSuccessor(nextProcedureIE.first) }
        }

        if (state._successors.isEmpty() && program._procedures.isNotEmpty()) state.addSuccessor(program._procedures.first().accept(this).first)

        // Link last procedure to first variable, or statement if there is no variable
        if (program._procedures.isNotEmpty()) {
            val lastProcedureIE = program._procedures.last().accept(this)
            if (program._variables.isNotEmpty()) {
                lastProcedureIE.second.forEach { it.addSuccessor(program._variables.first().accept(this).first) }
            } else if (program._statements.isNotEmpty()) {
                lastProcedureIE.second.forEach { it.addSuccessor(program._statements.first().accept(this).first) }
            }
        }

        // Visit all variables
        for (i in 0 until program._variables.size - 1) {
            val currentVariableIE = program._variables[i].accept(this)
            val nextVariableIE = program._variables[i + 1].accept(this)

            currentVariableIE.second.forEach { it.addSuccessor(nextVariableIE.first) }
        }

        if (state._successors.isEmpty() && program._variables.isNotEmpty()) state.addSuccessor(program._variables.first().accept(this).first)

        // Link last variable to first statement
        if (this._program._variables.isNotEmpty() && this._program._statements.isNotEmpty())
            this._program._variables.last().accept(this).second.forEach { it.addSuccessor(this._program._statements.first().accept(this).first) }

        // Visit all statements
        for (i in 0 until program._statements.size - 1) {
            val currentStatementIE = program._statements[i].accept(this)
            val nextStatementIE = program._statements[i + 1].accept(this)

            currentStatementIE.second.forEach { it.addSuccessor(nextStatementIE.first) }
        }

        if (state._successors.isEmpty() && program._statements.isNotEmpty()) state.addSuccessor(program._statements.first().accept(this).first)

        return Pair(
            state,
            program._statements.last().accept(this).second
        )
    }

    override fun visit(procedure: Procedure): Pair<State, List<State>> {
        return this._cache.getOrPut(procedure) {
            val state = createOrGetExistingState(procedure, "Procedure ${procedure._name}")
            state.addSuccessor(procedure._statements.first().accept(this).first)

            for (i in 0 until procedure._statements.size - 1) {
                val currentStatementIE = procedure._statements[i].accept(this)
                val nextStatementIE = procedure._statements[i + 1].accept(this)

                currentStatementIE.second.forEach { it.addSuccessor(nextStatementIE.first) }
            }
            // Link last statement to procedure (end)
            procedure._statements.last().accept(this).second.forEach { it.addSuccessor(state) }

            Pair(state, listOf(state))
        }
    }

    override fun visit(block: Block): Pair<State, List<State>> {
        return this._cache.getOrPut(block) {
            for (i in 0 until block._statements.size - 1) {
                val currentStatementIE = block._statements[i].accept(this)
                val nextStatementIE = block._statements[i + 1].accept(this)

                // Connect exits of the current statement to the entry of the next statement
                currentStatementIE.second.forEach { it.addSuccessor(nextStatementIE.first) }
            }

            Pair(
                block._statements.first().accept(this).first,
                block._statements.last().accept(this).second
            )
        }
    }

    override fun visit(variable: Variable): Pair<State, List<State>> {
        return this._cache.getOrPut(variable) {
            val state = createOrGetExistingState(variable, variable.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(variableBlock: VariableBlock): Pair<State, List<State>> {
        return this._cache.getOrPut(variableBlock) {
            val state = createOrGetExistingState(variableBlock, variableBlock.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression): Pair<State, List<State>> {
        return this._cache.getOrPut(unaryArithmeticExpression) {
            val state = createOrGetExistingState(unaryArithmeticExpression, unaryArithmeticExpression.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression): Pair<State, List<State>> {
        return this._cache.getOrPut(binaryArithmeticExpression) {
            val state = createOrGetExistingState(binaryArithmeticExpression, binaryArithmeticExpression.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(arithmeticConstant: ArithmeticConstant): Pair<State, List<State>> {
        return this._cache.getOrPut(arithmeticConstant) {
            val state = createOrGetExistingState(arithmeticConstant, arithmeticConstant.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression): Pair<State, List<State>> {
        return this._cache.getOrPut(arithmeticIdentifierExpression) {
            val state = createOrGetExistingState(arithmeticIdentifierExpression, arithmeticIdentifierExpression.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression): Pair<State, List<State>> {
        return this._cache.getOrPut(unaryBooleanExpression) {
            val state = createOrGetExistingState(unaryBooleanExpression, unaryBooleanExpression.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression): Pair<State, List<State>> {
        return this._cache.getOrPut(binaryBooleanExpression) {
            val state = createOrGetExistingState(binaryBooleanExpression, binaryBooleanExpression.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(booleanConstant: BooleanConstant): Pair<State, List<State>> {
        return this._cache.getOrPut(booleanConstant) {
            val state = createOrGetExistingState(booleanConstant, booleanConstant.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(assignStatement: AssignStatement): Pair<State, List<State>> {
        return this._cache.getOrPut(assignStatement) {
            val state = createOrGetExistingState(assignStatement, assignStatement.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(callStatement: CallStatement): Pair<State, List<State>> {
        return this._cache.getOrPut(callStatement) {
            val entry = createOrGetExistingState(callStatement, "Entry ${callStatement.accept(this._printer)}")
            val exit = createState(callStatement, "Exit ${callStatement.accept(this._printer)}")

            this._program._procedures.find { it._name == callStatement._procedureName }?.let { procedure ->
                val correspondingState = this._nodeToState[procedure]!!
                entry.addSuccessor(correspondingState)
                correspondingState.addSuccessor(exit)
            } ?: exitWithCode(
                ExitCode.INVALID_CALLSTATEMENT,
                "for procedure ${callStatement._procedureName} at position ${callStatement._position}"
            )

            Pair(entry, listOf(exit))
        }
    }

    override fun visit(ifStatement: IfStatement): Pair<State, List<State>> {
        return this._cache.getOrPut(ifStatement) {
            val conditionIE = ifStatement._condition.accept(this)
            val thenIE = ifStatement._thenBody.accept(this)
            val elseIE = ifStatement._elseBody?.accept(this)

            val entry = conditionIE.first

            // Connect condition's exit to the blocks' entry
            conditionIE.second.forEach { it.addSuccessor(thenIE.first) }
            conditionIE.second.forEach {currentConditionExit ->
                elseIE?.first?.let { currentConditionExit.addSuccessor(it) }
            }

            val exits = mutableListOf<State>()
            exits += thenIE.second
            // If there is an else body, the clause can't skip both block, but if there isn't, the condition can jump out
            exits += elseIE?.second ?: conditionIE.second

            Pair(entry, exits)
        }
    }

    override fun visit(skipStatement: SkipStatement): Pair<State, List<State>> {
        return this._cache.getOrPut(skipStatement) {
            val state = createOrGetExistingState(skipStatement, skipStatement.accept(this._printer))
            Pair(state, listOf(state))
        }
    }

    override fun visit(whileStatement: WhileStatement): Pair<State, List<State>> {
        return this._cache.getOrPut(whileStatement) {
            val conditionIE = whileStatement._condition.accept(this)
            val bodyIE = whileStatement._body.accept(this)

            conditionIE.second.forEach { it.addSuccessor(bodyIE.first) }
            bodyIE.second.forEach { it.addSuccessor(conditionIE.first) }

            Pair(conditionIE.first, conditionIE.second)
        }
    }
}