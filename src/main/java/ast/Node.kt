package ast

import visitor.IVisitor

abstract class Node(val _position: Position) {
    abstract fun <T> accept(visitor: IVisitor<T>): T
}