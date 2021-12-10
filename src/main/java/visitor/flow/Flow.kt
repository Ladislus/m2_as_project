package visitor.flow

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

class Flow(
    _program: Program
    ): DefaultFlow(_program) {

        init {
            this._program.accept(this)
        }

    override fun visit(program: Program): EntryExits? {

        // Procedure declarations flow
        for (i in 0 until program._procedures.size - 1) {
            val currentProcedureState = createOrGetExistingState(program._procedures[i])
            val currentProcedureEntryExits = program._procedures[i].accept(this)
            val nextProcedureState = createOrGetExistingState(program._procedures[i + 1])

            currentProcedureEntryExits?._entry?.let { currentEntry -> currentProcedureState.addSuccessor(currentEntry) }
            currentProcedureState.addSuccessor(nextProcedureState)
        }

        // Last procedure declaration is linked to first variable declaration
        if (program._procedures.isNotEmpty() && program._variables.isNotEmpty())
            program._variables.first().accept(this)?._entry?.let { firstVariableEntry ->
                createOrGetExistingState(
                    program._procedures.last()
                ).addSuccessor(
                    firstVariableEntry
                )
            }

        // Variable declarations flow
        for (i in 0 until program._variables.size - 1) {
            val currentVariableEntryExits = program._variables[i].accept(this)
            val nextVariableEntryExits = program._variables[i + 1].accept(this)

            // All the exits of the current variable block are linked to the entry of the next variable block
            currentVariableEntryExits?._exits?.forEach {
                currentVariableExits -> nextVariableEntryExits?._entry?.let {
                    nextVariableEntry -> currentVariableExits.addSuccessor(nextVariableEntry)
                }
            }
        }

        // Last variable declaration is linked to first statement
        if (program._variables.isNotEmpty() && program._statements.isNotEmpty()) {
            val firstStatementEntryExits = program._statements.first().accept(this)
            program._variables.last().accept(this)?._exits?.forEach{ lastVariableExits ->
                firstStatementEntryExits?._entry?.let { firstStatementEntry ->
                    lastVariableExits.addSuccessor(firstStatementEntry)
                }
            }
        }

        // Statements flow
        for (i in 0 until program._statements.size - 1) {
            val currentStatementEntryExits = program._statements[i].accept(this)
            val nextStatementEntryExits = program._statements[i + 1].accept(this)

            // All the exits of the current block are linked to the entry of the next block
            currentStatementEntryExits?._exits?.forEach { currentStatementsExits ->
                nextStatementEntryExits?._entry?.let { nextStatementEntry ->
                    currentStatementsExits.addSuccessor(nextStatementEntry)
                }
            }
        }

        return null
    }

    override fun visit(procedure: Procedure): EntryExits? {
        // Accept all the variables of the procedure to propagate the flow
        for (i in 0 until procedure._variables.size - 1) {
            val currentVariableEntryExits = procedure._variables[i].accept(this)
            val nextVariableEntryExits = procedure._variables[i + 1].accept(this)
            nextVariableEntryExits?._entry?.let { nextVariableEntry ->
                currentVariableEntryExits?._exits?.forEach { currentVariableExits ->
                    currentVariableExits.addSuccessor(nextVariableEntry)
                }
            }
        }
        if (procedure._variables.isNotEmpty()) {
            procedure._return?.accept(this)?._entry?.let { returnEntry ->
                procedure._variables.last().accept(this)?._exits?.forEach { lastVariableExits ->
                    lastVariableExits.addSuccessor(returnEntry)
                }
            } ?: run {
                procedure._statements.isNotEmpty().let {
                    val firstStatementEntryExits = procedure._statements.first().accept(this)
                    firstStatementEntryExits?._entry?.let { firstStatementEntry ->
                        procedure._variables.last().accept(this)?._exits?.forEach { lastVariableExits ->
                            lastVariableExits.addSuccessor(firstStatementEntry)
                        }
                    }
                }
            }
        }

        // Link all statements to together
        for (i in 0 until procedure._statements.size - 1) {
            val currentStatementEntryExits = procedure._statements[i].accept(this)
            val nextStatementEntryExits = procedure._statements[i + 1].accept(this)

            // All the exits of the current statement are linked to the entry of the next statement
            currentStatementEntryExits?._exits?.forEach { currentStatementsExits ->
                nextStatementEntryExits?._entry?.let { nextStatementEntry ->
                    currentStatementsExits.addSuccessor(nextStatementEntry)
                }
            }
        }

        return if (procedure._statements.isNotEmpty()) {
            val firstStatementEntryExits = procedure._statements.first().accept(this)!!
            val lastStatementEntryExits = procedure._statements.last().accept(this)!!
            EntryExits(
                firstStatementEntryExits._entry,
                lastStatementEntryExits._exits
            )
        } else null
    }

    override fun visit(block: Block): EntryExits? {
        // Link all statements to together
        for (i in 0 until block._statements.size - 1) {
            val currentStatementEntryExits = block._statements[i].accept(this)
            val nextStatementEntryExits = block._statements[i + 1].accept(this)

            // All the exits of the current statement are linked to the entry of the next statement
            currentStatementEntryExits?._exits?.forEach { currentStatementsExits ->
                nextStatementEntryExits?._entry?.let { nextStatementEntry ->
                    currentStatementsExits.addSuccessor(nextStatementEntry)
                }
            }
        }

        return if (block._statements.isNotEmpty()) {
            val firstStatementEntryExits = block._statements.first().accept(this)!!
            val lastStatementEntryExits = block._statements.last().accept(this)!!
            EntryExits(
                firstStatementEntryExits._entry,
                lastStatementEntryExits._exits
            )
        } else null
    }

    override fun visit(variable: Variable): EntryExits {
        val state = createOrGetExistingState(variable)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(variableBlock: VariableBlock): EntryExits? {
        // Link all variables to together
        for (i in 0 until variableBlock._variables.size - 1) {
            val currentVariableEntryExits = variableBlock._variables[i].accept(this)
            val nextVariableEntryExits = variableBlock._variables[i + 1].accept(this)

            // All the exits of the current variable are linked to the entry of the next variable
            currentVariableEntryExits?._exits?.forEach { currentVariableExits ->
                nextVariableEntryExits?._entry?.let { nextVariableEntry ->
                    currentVariableExits.addSuccessor(nextVariableEntry)
                }
            }
        }

        return if (variableBlock._variables.isNotEmpty()) {
            val firstVariableEntryExits = variableBlock._variables.first().accept(this)!!
            val lastVariableEntryExits = variableBlock._variables.last().accept(this)!!
            EntryExits(
                firstVariableEntryExits._entry,
                lastVariableEntryExits._exits
            )
        } else null
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression): EntryExits {
        // Accept the expression to propagate the flow
        unaryArithmeticExpression._expression.accept(this)
        val state = createOrGetExistingState(unaryArithmeticExpression)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression): EntryExits {
        // Accept the expressions to propagate the flow
        binaryArithmeticExpression._leftExpression.accept(this)
        binaryArithmeticExpression._rightExpression.accept(this)
        val state = createOrGetExistingState(binaryArithmeticExpression)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(arithmeticConstant: ArithmeticConstant): EntryExits {
        val state = createOrGetExistingState(arithmeticConstant)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression): EntryExits {
        val state = createOrGetExistingState(arithmeticIdentifierExpression)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression): EntryExits {
        // Accept the expression to propagate the flow
        unaryBooleanExpression._expression.accept(this)
        val state = createOrGetExistingState(unaryBooleanExpression)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression): EntryExits {
        // Accept the expressions to propagate the flow
        binaryBooleanExpression._leftExpression.accept(this)
        binaryBooleanExpression._rightExpression.accept(this)
        val state = createOrGetExistingState(binaryBooleanExpression)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(booleanConstant: BooleanConstant): EntryExits {
        val state = createOrGetExistingState(booleanConstant)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(assignStatement: AssignStatement): EntryExits {
        // Accept the expression to propagate the flow
        assignStatement._value.accept(this)
        val state = createOrGetExistingState(assignStatement)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(callStatement: CallStatement): EntryExits {
        // Link all arguments together
        for (i in 0 until callStatement._arguments.size - 1) {
            callStatement._arguments[i].accept(this)?._exits?.let { currentArgumentExits ->
                callStatement._arguments[i + 1].accept(this)?._entry?.let { nextArgumentEntry ->
                    currentArgumentExits.forEach { it.addSuccessor(nextArgumentEntry) }
                }
            }
        }

        val correspondingProcedureEntryExits = this._program._procedures.find { procedure: Procedure ->
            procedure._name == callStatement._procedureName
        }!!.accept(this)
        callStatement._arguments.last().accept(this)?._exits?.let { lastArgumentExits ->
            lastArgumentExits.forEach { currentLastArgumentExit ->
                correspondingProcedureEntryExits?._entry?.let { correspondingProcedureEntry ->
                    currentLastArgumentExit.addSuccessor(correspondingProcedureEntry)
                }
            }
        }

        val state = createOrGetExistingState(callStatement)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(ifStatement: IfStatement): EntryExits {
        val exits = mutableListOf<State>()
        val conditionEntryExits = ifStatement._condition.accept(this)!!
        val thenBlockEntryExits = ifStatement._thenBody.accept(this)

        conditionEntryExits._exits.forEach{ conditionExits ->
            thenBlockEntryExits?._entry?.let { thenBlockEntry ->
                conditionExits.addSuccessor(thenBlockEntry)
            }
        }
        thenBlockEntryExits?._exits?.let { thenBlockExits ->
            exits.addAll(thenBlockExits)
        }

        ifStatement._elseBody?.let { elseBody ->
            val elseBlockEntryExits = elseBody.accept(this)!!
            conditionEntryExits._exits.forEach{ it.addSuccessor(elseBlockEntryExits._entry) }
            exits.addAll(elseBlockEntryExits._exits)
        } ?: exits.addAll(conditionEntryExits._exits)

        return EntryExits(
            conditionEntryExits._entry,
            exits
        )
    }

    override fun visit(skipStatement: SkipStatement): EntryExits {
        val state = createOrGetExistingState(skipStatement)
        return EntryExits(
            state,
            mutableListOf(state)
        )
    }

    override fun visit(whileStatement: WhileStatement): EntryExits {
        val conditionEntryExits = whileStatement._condition.accept(this)!!
        val blockEntryExits = whileStatement._body.accept(this)

        blockEntryExits?._entry?.let { blockEntry ->
            conditionEntryExits._exits.forEach { conditionExits ->
                conditionExits.addSuccessor(blockEntry)
            }
        }
        blockEntryExits?._exits?.forEach { blockExits ->
            blockExits.addSuccessor(conditionEntryExits._entry)
        }

        return EntryExits(
            conditionEntryExits._entry,
            conditionEntryExits._exits
        )
    }
}