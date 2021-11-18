package ast;

import java.util.Optional;

public class Declaration extends Node {

    private final Type _type;
    private final String _name;
    private final Optional<Expression> _expression;
}
