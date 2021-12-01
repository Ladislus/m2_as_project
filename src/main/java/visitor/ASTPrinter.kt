package visitor

import ast.*
import ast.expression.arithmetic.ArithmeticConstant
import ast.expression.arithmetic.BinaryArithmeticExpression
import ast.expression.arithmetic.IdentifierExpression
import ast.expression.arithmetic.UnaryArithmeticExpression
import ast.expression.bool.BinaryBooleanExpression
import ast.expression.bool.BooleanConstant
import ast.expression.bool.UnaryBooleanExpression
import ast.statement.*

// TODO Implement (Question 2)
class ASTPrinter: DefaultVisitor<String>() {

    override fun visit(program: Program): String {
        var result = "program ${program._identifier}\n"
        program._procedures.forEach { result += it.accept(this) + "\n" }
        result += "begin"
        program._variables.forEach { result += it.accept(this) + "\n" }
        program._statements.forEach { result += it.accept(this) + "\n"}
        result += "end\n"

        return result
    }

    override fun visit(procedure: Procedure): String {
        var result = "procedure ${procedure._name}("
        procedure._variables.joinToString(", ") { it.accept(this) }
        procedure._return?.let { result += ", res " + it.accept(this) }
        result += ") begin\n"
        procedure._statements.forEach { result += "\t" + it.accept(this) }
        result += "end"

        return result
    }

    override fun visit(type: Type) =
        type.type._representation

    override fun visit(position: Position) =
        "Position(${position._line}, ${position._column})"

    override fun visit(variable: Variable) =
        "${variable._type.accept(this)} ${variable._name} ${variable._expression?.let { " = " + it.accept(this) }}"

    override fun visit(variableBlock: VariableBlock) =
        if (variableBlock._variables.isEmpty()) {
            ""
        } else {
            variableBlock._variables.first()._type.accept(this) + variableBlock._variables.joinToString(", ") { it._name }
        }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) =
        "${unaryArithmeticExpression._operator._representation} ${unaryArithmeticExpression._expression.accept(this)}"

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) =
        "${binaryArithmeticExpression._leftExpression.accept(this)} ${binaryArithmeticExpression._operator._representation} ${binaryArithmeticExpression._rightExpression.accept(this)}"

    override fun visit(arithmeticConstant: ArithmeticConstant) =
        arithmeticConstant._value.toString()

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression) =
        arithmeticIdentifierExpression._identifier

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression) =
        "${unaryBooleanExpression._operator._representation} ${unaryBooleanExpression._expression.accept(this)}"

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression) =
        "${binaryBooleanExpression._leftExpression.accept(this)} ${binaryBooleanExpression._operator._representation} ${binaryBooleanExpression._rightExpression.accept(this)}"

    override fun visit(booleanConstant: BooleanConstant) =
        booleanConstant._value.toString()

    override fun visit(assignStatement: AssignStatement) =
        "${assignStatement._variableName} = ${assignStatement._value.accept(this)}"

    override fun visit(callStatement: CallStatement) =
        "call ${callStatement._procedureName}${callStatement._arguments.joinToString(", ", prefix = "(", postfix = ")") { it.accept(this) }}"

    override fun visit(ifStatement: IfStatement) =
        "if ${ifStatement._condition.accept(this)} then\n${ifStatement._thenBody.accept(this)}\n${ifStatement._elseBody?.let { "else\n" + it.accept(this) }}"

    override fun visit(skipStatement: SkipStatement) =
        "skip"

    override fun visit(whileStatement: WhileStatement) =
        "while ${whileStatement._condition.accept(this)} do\n${whileStatement._body.accept(this)}"
}