package ast


open class Variable(
        position: Position,
        val _type: Type,
        val _name: String,
        ) : Node(position)