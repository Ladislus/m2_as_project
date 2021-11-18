package ast;

public abstract class Node {

    protected final Position _position;

    public Node(Position position) {
        this._position = position;
    }

    public Position getPosition() {
        return this._position;
    }
}