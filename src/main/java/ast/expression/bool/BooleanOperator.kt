package ast.expression.bool

enum class BinaryBooleanOperator(val _representation: String) {
    LESS("<"),
    LESS_EQUAL("<="),
    EQUAL("="),
    GREATER_EQUAL(">="),
    GREATER(">"),
    DIFFERENT("<>");
}

fun binaryBooleanOperatorFromString(representation: String): BinaryBooleanOperator {
    return when (representation) {
        "<" -> BinaryBooleanOperator.LESS
        "<=" -> BinaryBooleanOperator.LESS_EQUAL
        "=" -> BinaryBooleanOperator.EQUAL
        ">=" -> BinaryBooleanOperator.GREATER_EQUAL
        ">" -> BinaryBooleanOperator.GREATER
        "<>" -> BinaryBooleanOperator.DIFFERENT
        else -> throw IllegalArgumentException("Unknown binary boolean operator: $representation")
    }
}

enum class UnaryBooleanOperator(val _representation: String) {
    NOT("not");
}

fun unaryBooleanOperatorFromString(representation: String): UnaryBooleanOperator {
    return when (representation) {
        "not" -> UnaryBooleanOperator.NOT
        else -> throw IllegalArgumentException("Unknown unary boolean operator: $representation")
    }
}