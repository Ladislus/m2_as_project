package ast

import ast.Procedure
import ast.Declaration
import java.util.ArrayList

class Program(position: Position?, procedures: List<Procedure>?, declarations: List<Declaration>?) : Node(position) {
    private val _procedures: MutableList<Procedure> = ArrayList()
    private val _declarations: MutableList<Declaration> = ArrayList()

    init {
        _procedures.addAll(procedures!!)
        _declarations.addAll(declarations!!)
    }
}