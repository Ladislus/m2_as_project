package visitor.flow

import ast.Node

class State(
    val _identifier: String,
    val _index: Int,
    val _node: Node,
    var _predecessors: MutableSet<State> = mutableSetOf(),
    var _successors: MutableSet<State> = mutableSetOf()
    ) {
    fun addSuccessor(successor: State) {
        this._successors.add(successor)
        successor._predecessors.add(this)
    }
}