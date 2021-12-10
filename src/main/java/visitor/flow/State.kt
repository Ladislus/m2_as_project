package visitor.flow

class State(
    val _identifier: String,
    val _index: Int,
    var _predecessors: MutableSet<State> = mutableSetOf(),
    var _successors: MutableSet<State> = mutableSetOf()
    ) {
    fun addSuccessor(successor: State) {
        this._successors.add(successor)
        successor._predecessors.add(this)
    }
}