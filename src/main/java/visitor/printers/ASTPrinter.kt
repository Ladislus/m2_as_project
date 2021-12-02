package visitor.printers

import ast.*
import ast.declaration.Variable
import ast.declaration.VariableBlock
import ast.expression.arithmetic.ArithmeticConstant
import ast.expression.arithmetic.BinaryArithmeticExpression
import ast.expression.arithmetic.IdentifierExpression
import ast.expression.arithmetic.UnaryArithmeticExpression
import ast.expression.bool.BinaryBooleanExpression
import ast.expression.bool.BooleanConstant
import ast.expression.bool.UnaryBooleanExpression
import ast.statement.*
import visitor.DefaultVisitor

class ASTPrinter: DefaultVisitor<String>() {

    override fun visit(program: Program): String {
        var result = "PROGRAM ${program._identifier?.let { "identifier(${it})" } ?: ""}\n"
        program._procedures.forEach { result += it.accept(this) + "\n" }
        result += "BEGIN\n"
        program._variables.forEach { result += it.accept(this) + "\n" }
        program._statements.forEach { result += it.accept(this) + "\n" }
        result += "END"

        return result
    }

    override fun visit(procedure: Procedure): String {
        var result = "PROCEDURE identifier(${procedure._name})("
        result += procedure._variables.joinToString(", ") { it.accept(this) }
        procedure._return?.let { result += ", RES " + it.accept(this) }
        result += ")\nBEGIN\n"
        procedure._statements.forEach { result += "\t" + it.accept(this) + "\n"}

        return result
    }

    override fun visit(type: Type) =
        "TYPE(${type.type._representation})"

    override fun visit(position: Position) =
        "POSITION(${position._line}, ${position._column})"

    override fun visit(block: Block) =
        "BLOCK(${block._statements.joinToString("\n") { it.accept(this) }})"

    override fun visit(variable: Variable) =
        "VARIABLE(${variable._type.accept(this)} identifier(${variable._name}))"

    override fun visit(variableBlock: VariableBlock) =
        if (variableBlock._variables.isNotEmpty()) {
            "VARIABLEBLOCK(${variableBlock._variables.first()._type.accept(this)} ${variableBlock._variables.joinToString(", ") { it.accept(this) }}"
        } else "VARIABLEBLOCK()"

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) =
        "UNARYARITHMETICEXPRESSION(UNARYARITHMETICOPERATOR(${unaryArithmeticExpression._operator._representation}) ${unaryArithmeticExpression._expression.accept(this)})"

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) =
        "BINARYARITHMETICEXPRESSION(${binaryArithmeticExpression._leftExpression.accept(this)} BINARYARITHMETICOPERATOR(${binaryArithmeticExpression._operator._representation}) ${binaryArithmeticExpression._rightExpression.accept(this)})"

    override fun visit(arithmeticConstant: ArithmeticConstant) =
        "ARITHMETICCONSTANT(${arithmeticConstant._value})"

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression) =
        "ARITHMETICIDENTIFIEREXPRESSION(identifier(${arithmeticIdentifierExpression._identifier}))"

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression) =
        "UNARYBOOLEANEXPRESSION(UNARYBOOLEANOPERATOR(${unaryBooleanExpression._operator._representation}) ${unaryBooleanExpression._expression.accept(this)})"

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression) =
        "BINARYBOOLEANEXPRESSION(${binaryBooleanExpression._leftExpression.accept(this)} BINARYBOOLEANOPERATOR(${binaryBooleanExpression._operator._representation}) ${binaryBooleanExpression._rightExpression.accept(this)})"

    override fun visit(booleanConstant: BooleanConstant) =
        "BOOLEANCONSTANT(${booleanConstant._value})"

    override fun visit(assignStatement: AssignStatement) =
        "ASSIGNSTATEMENT(identifier(${assignStatement._variableName}, ${assignStatement._value.accept(this)})"

    override fun visit(callStatement: CallStatement) =
        "CALLSTATEMENT(identifier(${callStatement._procedureName}, ${callStatement._arguments.joinToString(", ") { it.accept(this) }})"

    override fun visit(ifStatement: IfStatement) =
        "IFSTATEMENT(${ifStatement._condition.accept(this)} ${ifStatement._thenBody.accept(this)} ${ifStatement._elseBody?.accept(this) ?: ""})"

    override fun visit(skipStatement: SkipStatement) =
        "SKIPSTATEMENT"

    override fun visit(whileStatement: WhileStatement) =
        "WHILESTATEMENT(${whileStatement._condition.accept(this)}, ${whileStatement._body.accept(this)})"
}