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
import visitor.DefaultVisitor

class ForwardFlow(
    private val _flow: MutableMap<Node, MutableList<Node>> = mutableMapOf(),
    private val _stack: ArrayDeque<Node> = ArrayDeque()
    ): DefaultVisitor<List<Node>>(), IFlow {

    private lateinit var _program: Program

    // IFlow Methods
    override fun constructFlow(program: Program) { program.accept(this) }
    override fun hasNext(): Boolean = !_stack.isEmpty()
    override fun getNext(): Node {
        val node = this._stack.removeFirst()
        this._flow[node]?.let { this._stack.addAll(it) }
        return node
    }
    // IFlow Methods end

    // Utility Methods
    private fun addSuccessor(node: Node, successor: Node) {
        this._flow.getOrPut(node) { mutableListOf() }.add(successor)
    }

    private fun addSuccessor(node: Node, successors: List<Node>) {
        this._flow.getOrPut(node) { mutableListOf() }.addAll(successors)
    }
    // Utility Methods end

    override fun visit(program: Program): List<Node> {

        this._program = program

        // Procedure
        for (i in 0 until program._procedures.size - 1) {
            val current = program._procedures[i]
            val successor = program._procedures[i + 1]
            addSuccessor(current, successor)
        }
        program._procedures.forEach { it.accept(this) }

        // First variable is the successor of the last procedure definition
        if (program._procedures.isNotEmpty() && program._variables.isNotEmpty())
            addSuccessor(
                program._procedures.last(),
                program._variables.first()
            )


        // Variable
        for (i in 0 until program._variables.size - 1) {
            val current = program._variables[i]
            val successor = program._variables[i + 1]
            addSuccessor(current, successor)
        }
        program._variables.forEach { it.accept(this) }

        // First statement is the successor of the last variable
        if (program._statements.isNotEmpty() && program._variables.isNotEmpty())
            addSuccessor(
                program._variables.last(),
                program._statements.first()
            )

        // Statements
        for (i in 0 until program._statements.size - 1) {
            val current = program._statements[i]
            val successor = program._statements[i + 1]
            addSuccessor(current, successor)
        }
        program._statements.forEach { it.accept(this) }

        return emptyList()
    }

    override fun visit(procedure: Procedure): List<Node> {
        if (procedure._statements.isNotEmpty())
            addSuccessor(
                procedure,
                procedure._statements.first()
            )
        for (i in 0 until procedure._statements.size - 1) {
            val current = procedure._statements[i]
            val successor = procedure._statements[i + 1]
            addSuccessor(current, successor)
        }
        procedure._statements.forEach { it.accept(this) }

        return emptyList()
    }

    override fun visit(type: Type) = emptyList<Node>()

    override fun visit(position: Position) = emptyList<Node>()

    override fun visit(block: Block): List<Node> {
        if (block._statements.isNotEmpty())
            addSuccessor(
                block,
                block._statements.first()
            )
        for (i in 0 until block._statements.size - 1) {
            val current = block._statements[i]
            val successor = block._statements[i + 1]
            addSuccessor(current, successor)
        }
        block._statements.forEach { it.accept(this) }

        return emptyList()
    }

    override fun visit(variable: Variable) = emptyList<Node>()

    override fun visit(variableBlock: VariableBlock): List<Node> {
        if (variableBlock._variables.isNotEmpty())
            addSuccessor(
                variableBlock,
                variableBlock._variables.first()
            )
        for (i in 0 until variableBlock._variables.size - 1) {
            val current = variableBlock._variables[i]
            val successor = variableBlock._variables[i + 1]
            addSuccessor(current, successor)
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
        this._program._procedures.find { it._name == callStatement._procedureName }?.let {
            addSuccessor(
                callStatement,
                it
            )
        }

        return emptyList()
    }

    override fun visit(ifStatement: IfStatement): List<Node> {
        addSuccessor(
            ifStatement._condition,
            ifStatement._thenBody
        )
        ifStatement._thenBody.accept(this)

        ifStatement._elseBody?.let {
            addSuccessor(
                ifStatement._condition,
                ifStatement._elseBody
            )
            ifStatement._elseBody.accept(this)
        }

        return emptyList()
    }

    override fun visit(skipStatement: SkipStatement) = emptyList<Node>()

    override fun visit(whileStatement: WhileStatement): List<Node> {
        addSuccessor(
            whileStatement._condition,
            whileStatement._body
        )
        whileStatement._body.accept(this)
        addSuccessor(
            whileStatement._body._statements.first(),
            whileStatement._condition
        )

        return emptyList()
    }
}