package ast

import ast.expression.Expression

class Declaration(
        position: Position,
        type: Type,
        variableName: String,
        val _expression: Expression?
        ) : Variable(position, type, variableName)