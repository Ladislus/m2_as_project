package ast;

public class Position {

    private final int _line;
    private final int _column;

    public Position(int line, int column) {
        this._line = line;
        this._column = column;
    }

    public int getLine() {
        return this._line;
    }

    public int getColumn() {
        return this._column;
    }
}
