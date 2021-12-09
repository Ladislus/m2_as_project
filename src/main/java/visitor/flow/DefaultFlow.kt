package visitor.flow

import ast.Node
import ast.Program
import visitor.DefaultVisitor

abstract class DefaultFlow(
    protected val _flow: MutableMap<Node, MutableList<Node>> = mutableMapOf(),
    private val _stack: ArrayDeque<Node> = ArrayDeque()
    ): IFlow, DefaultVisitor<List<Node>>() {

    protected lateinit var _program: Program

    override fun hasNext(): Boolean = this._stack.isNotEmpty()
    override fun getNext(): Node {
        val node = this._stack.removeFirst()
        this._flow[node]?.let { this._stack.addAll(it) }
        return node
    }
}