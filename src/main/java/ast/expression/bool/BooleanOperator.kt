package ast.expression.bool

enum class BooleanOperator(val _representation: String) {
    LESS("<"),
    LESS_EQUAL("<="),
    EQUAL("="),
    GREATER_EQUAL(">="),
    GREATER(">"),
    DIFFERENT("<>");
}

fun BooleanOperatorFromString(representation: String): BooleanOperator {
    return when (representation) {
        "<" -> BooleanOperator.LESS
        "<=" -> BooleanOperator.LESS_EQUAL
        "=" -> BooleanOperator.EQUAL
        ">=" -> BooleanOperator.GREATER_EQUAL
        ">" -> BooleanOperator.GREATER
        "<>" -> BooleanOperator.DIFFERENT
        else -> throw IllegalArgumentException("Unknown boolean operator: $representation")
    }
}