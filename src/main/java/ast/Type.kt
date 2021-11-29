package ast

class Type(position: Position, type: PossibleTypes) : Node(position)

enum class PossibleTypes(val _respresentation: String) {
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