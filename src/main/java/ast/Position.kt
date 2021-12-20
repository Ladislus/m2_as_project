package ast

class Position(val _line: Int, val _column: Int) {
    override fun toString(): String {
        return "(${this._line}, ${this._column})"
    }
}