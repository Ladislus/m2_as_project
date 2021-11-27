package ast

class VariableBlock(
        position: Position,
        val _variables: List<Variable>
        ): Node(position)