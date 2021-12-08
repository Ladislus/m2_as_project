package visitor.flow

import ast.Node
import ast.Program

interface IFlow {
    fun constructFlow(program: Program)
    fun hasNext(): Boolean
    fun getNext(): Node
}