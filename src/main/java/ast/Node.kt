package ast

import visitor.Visitor

abstract class Node(val _position: Position) {
    fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }
}