package ast

import visitor.IVisitor

class Type(position: Position, val type: PossibleTypes) : Node(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}

enum class PossibleTypes(val _representation: String) {
    INT("int"),
    BOOL("bool")
}

fun typeFromString(representation: String) : PossibleTypes {
    return when(representation) {
        "int" -> PossibleTypes.INT
        "bool" -> PossibleTypes.BOOL
        else -> throw IllegalArgumentException("Unknown type: $representation")
    }
}