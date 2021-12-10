package visitor.flow

import ast.Node
import ast.Position
import ast.Program
import ast.Type
import visitor.DefaultVisitor
import visitor.raiseIllegalStateExceptionWithClass


abstract class DefaultFlow(
    protected val _program: Program,
    ): IFlow, DefaultVisitor<Pair<State, List<State>>>() {

    private var _counter: Int = 0
        get() = ++field
    private var _head: State? = null
    private val _states: MutableSet<State> = mutableSetOf()
    private val _stack: ArrayDeque<State> = ArrayDeque()
    private val _nodeToState: MutableMap<Node, State> = mutableMapOf()

    override fun hasNext(): Boolean =
        this._stack.isNotEmpty()

    override fun getNext(): State =
        this._stack.removeLast()

    override fun pileSuccessors(currentState: State) {
        this._stack.addAll(currentState._successors)
    }

    override fun reverse(): IFlow {
        this._head?.let {
            this._states.forEach {
                val tmp = it._successors
                it._successors = it._predecessors
                it._predecessors = tmp
            }
        }
        return this
    }

    private fun createState(node: Node, identifier: String?): State {
        val state = State(identifier ?: node.javaClass.toString(), this._counter, node)
        this._states.add(state)
        if (this._head == null) {
            this._head = state
            this._stack.addFirst(state)
        }
        return state
    }

    override fun createOrGetExistingState(node: Node, identifier: String?): State =
        this._nodeToState.getOrPut(node) { createState(node, identifier) }

    override fun toDot(): String {
        var dot = "digraph G {\n"
        for (state in this._states.sortedBy { it._index }) {

            dot += "\tnode${state._index} [label=\"${state._identifier}\"] ${if (state == this._head) "[color=\"red\"]" else ""};\n"
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