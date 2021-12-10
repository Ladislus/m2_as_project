package visitor.flow

import ast.Node

interface IFlow {
    fun hasNext(): Boolean
    fun getNext(): State
    fun pileSuccessors(currentState: State)
    fun toDot(): String
    fun reverse()
    fun createOrGetExistingState(node: Node): State
}