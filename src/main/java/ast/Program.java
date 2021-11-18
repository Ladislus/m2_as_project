package ast;

import java.util.ArrayList;
import java.util.List;

public class Program extends Node {

    private final List<Procedure> _procedures = new ArrayList<>();
    private final List<Declaration> _declarations = new ArrayList<>();

    public Program(Position position, List<Procedure> procedures, List<Declaration> declarations) {
        super(position);

        this._procedures.addAll(procedures);
        this._declarations.addAll(declarations);
    }
}
