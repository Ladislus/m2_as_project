package ast.expression.arithmetic

enum class BinaryArithmeticOperator(val _representation: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/")
}

fun binaryArithmeticOperatorFromString(representation: String): BinaryArithmeticOperator {
    return when(representation) {
        "+" -> BinaryArithmeticOperator.PLUS
        "-" -> BinaryArithmeticOperator.MINUS
        "*" -> BinaryArithmeticOperator.MULTIPLY
        "/" -> BinaryArithmeticOperator.DIVIDE
        else -> throw IllegalArgumentException("Unknown binary arithmetic operator: $representation")
    }
}

enum class UnaryArithmeticOperator(val _representation: String) {
    MINUS("-")
}

fun unaryArithmeticOperatorFromString(representation: String): UnaryArithmeticOperator {
    return when(representation) {
        "-" -> UnaryArithmeticOperator.MINUS
        else -> throw IllegalArgumentException("Unknown unary arithmetic operator: $representation")
    }
}