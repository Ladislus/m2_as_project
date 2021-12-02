package ast.statement

import ast.Position
import visitor.IVisitor

class SkipStatement(position: Position) : Statement(position) {
    override fun <T> accept(visitor: IVisitor<T>): T = visitor.visit(this)
}