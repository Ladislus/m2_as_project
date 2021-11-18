package ast

import java.util.Optional

class Declaration : Node() {
    private val _type: Type? = null
    private val _name: String? = null
    private val _expression: Optional<Expression>? = null
}