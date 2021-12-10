package visitor.flow

import ast.Node
import ast.Position
import ast.Program
import ast.Type
import visitor.DefaultVisitor
import visitor.raiseIllegalStateExceptionWithClass


abstract class DefaultFlow(
    protected val _program: Program,
): IFlow, DefaultVisitor<EntryExits?>() {

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

    override fun reverse() {
        this._head?.let {
            this._states.forEach {
                val tmp = it._successors
                it._successors = it._predecessors
                it._predecessors = tmp
            }
        }
    }

    private fun createState(node: Node): State {
        val state = State(node.javaClass.toString(), this._counter)
        this._states.add(state)
        if (this._head == null) this._head = state
        return state
    }

    override fun createOrGetExistingState(node: Node): State =
        this._nodeToState.getOrPut(node) { createState(node) }

    override fun toDot(): String {
        var dot = "digraph G {\n"
        for (state in this._states.sortedBy { it._index }) {
            dot += "\tnode${state._index} [label=\"${state._identifier}\"];\n"
            dot += "\tnode${state._index} -> {${state._successors.joinToString(" ") { "node" + it._index }}};\n"
        }
        dot += "}"
        return dot
    }

    override fun visit(type: Type): EntryExits? {
        raiseIllegalStateExceptionWithClass(type::class.java)
    }

    override fun visit(position: Position): EntryExits? {
        raiseIllegalStateExceptionWithClass(position::class.java)
    }
}