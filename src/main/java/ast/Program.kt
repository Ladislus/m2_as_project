package ast

class Program(
        position: Position,
        val _procedures: List<Procedure>,
        val _declarations: List<Declaration>
        ) : Node(position)