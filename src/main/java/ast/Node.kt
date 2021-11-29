package ast

import visitor.IVisitor

abstract class Node(val _position: Position) {
    fun <T> accept(visitor: IVisitor<T>): T {
        return visitor.visit(this)
    }
}