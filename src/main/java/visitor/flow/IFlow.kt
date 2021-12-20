package visitor.flow

import ast.Node
import ast.Program

interface IFlow {
    fun hasNext(): Boolean
    fun getNext(): State
    fun pileSuccessors(currentState: State)
    fun addToStack(state: State)
    fun toDot(): String
    fun getCorrespondingState(node: Node): State?
    fun createOrGetExistingState(node: Node, identifier: String? = null): State
    fun getProgram(): Program
}