package ast.expression.arithmetic

enum class ArithmeticOperator(val _representation: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/")
}

fun arithmeticOperatorFromString(representation: String): ArithmeticOperator {
    return when(representation) {
        "+" -> ArithmeticOperator.PLUS
        "-" -> ArithmeticOperator.MINUS
        "*" -> ArithmeticOperator.MULTIPLY
        "/" -> ArithmeticOperator.DIVIDE
        else -> throw IllegalArgumentException("Unknown arithmetic operator: $representation")
    }
}