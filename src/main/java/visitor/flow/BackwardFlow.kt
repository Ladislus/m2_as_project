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

class BackwardFlow: DefaultFlow() {

    // IFlow Methods
    override fun constructFlow(program: Program) {
        this._program = program
        this._program.accept(this)
    }
    // IFlow Methods end

    // Utility Methods
    private fun addPredecessor(node: Node, predecessors: Node) {
        this._flow.getOrPut(node) { mutableListOf() }.add(predecessors)
    }
    // Utility Methods end

    override fun visit(program: Program): List<Node> {
        // Procedure
        for (i in program._procedures.size - 1 downTo 1) {
            val current = program._procedures[i]
            val predecessor = program._procedures[i - 1]
            addPredecessor(current, predecessor)
        }
        program._procedures.forEach { it.accept(this) }

        // Last procedure definition is the predecessor of the first variable
        if (program._procedures.isNotEmpty() && program._variables.isNotEmpty())
            addPredecessor(
                program._variables.first(),
                program._procedures.last()
            )

        // Variable
        for (i in program._variables.size - 1 downTo 1) {
            val current = program._variables[i]
            val predecessor = program._variables[i - 1]
            addPredecessor(current, predecessor)
        }
        program._variables.forEach { it.accept(this) }

        // Last variable definition is the predecessor of the first statement
        if (program._statements.isNotEmpty() && program._variables.isNotEmpty())
            addPredecessor(
                program._statements.first(),
                program._variables.last()
            )

        // Statements
        for (i in program._statements.size - 1 downTo 1) {
            val current = program._statements[i]
            val predecessor = program._statements[i - 1]
            addPredecessor(current, predecessor)
        }
        program._statements.forEach { it.accept(this) }

        return emptyList()
    }

    override fun visit(procedure: Procedure): List<Node> {
        TODO("Not yet fixed")
        if (procedure._statements.isNotEmpty())
            addPredecessor(
                procedure,
                procedure._statements.first()
            )
        for (i in 0 until procedure._statements.size - 1) {
            val current = procedure._statements[i]
            val successor = procedure._statements[i + 1]
            addPredecessor(current, successor)
        }
        procedure._statements.forEach { it.accept(this) }

        return emptyList()
    }

    override fun visit(type: Type) = emptyList<Node>()

    override fun visit(position: Position) = emptyList<Node>()

    override fun visit(block: Block): List<Node> {
        TODO("Not yet fixed")
        if (block._statements.isNotEmpty())
            addPredecessor(
                block,
                block._statements.first()
            )
        for (i in 0 until block._statements.size - 1) {
            val current = block._statements[i]
            val successor = block._statements[i + 1]
            addPredecessor(current, successor)
        }
        block._statements.forEach { it.accept(this) }

        return emptyList()
    }

    override fun visit(variable: Variable) = emptyList<Node>()

    override fun visit(variableBlock: VariableBlock): List<Node> {
        TODO("Not yet fixed")
        if (variableBlock._variables.isNotEmpty())
            addPredecessor(
                variableBlock,
                variableBlock._variables.first()
            )
        for (i in 0 until variableBlock._variables.size - 1) {
            val current = variableBlock._variables[i]
            val successor = variableBlock._variables[i + 1]
            addPredecessor(current, successor)
        }
        variableBlock._variables.forEach { it.accept(this) }

        return emptyList()
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) = emptyList<Node>()

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) = emptyList<Node>()

    override fun visit(arithmeticConstant: ArithmeticConstant) = emptyList<Node>()

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression) = emptyList<Node>()

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression) = emptyList<Node>()

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression) = emptyList<Node>()

    override fun visit(booleanConstant: BooleanConstant) = emptyList<Node>()

    override fun visit(assignStatement: AssignStatement) = emptyList<Node>()

    override fun visit(callStatement: CallStatement): List<Node> {
        TODO("Not yet fixed")
        this._program._procedures.find { it._name == callStatement._procedureName }?.let {
            addPredecessor(
                callStatement,
                it
            )
        }

        return emptyList()
    }

    override fun visit(ifStatement: IfStatement): List<Node> {
        TODO("Not yet fixed")
        addPredecessor(
            ifStatement._condition,
            ifStatement._thenBody
        )
        ifStatement._thenBody.accept(this)

        ifStatement._elseBody?.let {
            addPredecessor(
                ifStatement._condition,
                ifStatement._elseBody
            )
            ifStatement._elseBody.accept(this)
        }

        return emptyList()
    }

    override fun visit(skipStatement: SkipStatement) = emptyList<Node>()

    override fun visit(whileStatement: WhileStatement): List<Node> {
        TODO("Not yet fixed")
        addPredecessor(
            whileStatement._condition,
            whileStatement._body
        )
        whileStatement._body.accept(this)
        addPredecessor(
            whileStatement._body._statements.first(),
            whileStatement._condition
        )

        return emptyList()
    }
}