package visitor.flow

import ast.Node
import ast.Position
import ast.Program
import ast.Type
import utils.ExitCode
import utils.exitWithCode
import visitor.DefaultVisitor
import visitor.raiseIllegalStateExceptionWithClass


abstract class DefaultFlow(
    protected val _program: Program,
    private val reversed: Boolean
    ): IFlow, DefaultVisitor<Pair<State, List<State>>>() {

    private var _counter: Int = 0
        get() = field++
    protected var _heads: MutableSet<State> = mutableSetOf()
    protected var _tails: MutableSet<State> = mutableSetOf()
    private val _states: MutableSet<State> = mutableSetOf()
    private val _stack: ArrayDeque<State> = ArrayDeque()
    private val _nodeToState: MutableMap<Node, State> = mutableMapOf()

    override fun getProgram(): Program =
        this._program

    override fun hasNext(): Boolean =
        this._stack.isNotEmpty()

    override fun getNext(): State =
        this._stack.removeLast()

    override fun pileSuccessors(currentState: State) {
        this._stack.addAll(currentState._successors)
    }

    override fun addToStack(state: State) {
        this._stack.add(state)
    }

    protected fun initStack() {
        if (this.reversed) {
            this.reverse()
        }

        this._stack += this._heads
        if (this._stack.isEmpty()) exitWithCode(ExitCode.EMPTY_FLOW)
    }

    private fun reverse() {
        if (this._states.isNotEmpty()) {
            this._states.forEach {
                val tmp = it._successors
                it._successors = it._predecessors
                it._predecessors = tmp
            }
        }
        val tmp = this._heads
        this._heads = this._tails
        this._tails = tmp
    }

    protected fun createState(node: Node, identifier: String?): State {
        val state = State(identifier ?: node.javaClass.toString(), this._counter, node)
        this._states.add(state)
        return state
    }

    override fun getCorrespondingState(node: Node): State? {
        return this._nodeToState[node]
    }

    override fun createOrGetExistingState(node: Node, identifier: String?): State =
        this._nodeToState.getOrPut(node) { createState(node, identifier) }

    override fun toDot(): String {
        var dot = "digraph G {\n"
        for (state in this._states.sortedBy { it._index }) {
            dot += "\tnode${state._index} [style=filled] [label=\"${state._identifier}\"] ${if (state in this._heads) "[fillcolor=\"crimson\"]" else if (state in this._tails) "[fillcolor=\"skyblue1\"]" else "[fillcolor=\"white\"]"};\n"
            dot += "\tnode${state._index} -> {${state._successors.joinToString(" ") { "node" + it._index }}};\n"
        }
        dot += "}"
        return dot
    }

    override fun visit(type: Type): Pair<State, List<State>> {
        raiseIllegalStateExceptionWithClass(type::class.java)
    }

    override fun visit(position: Position): Pair<State, List<State>> {
        raiseIllegalStateExceptionWithClass(position::class.java)
    }
}
