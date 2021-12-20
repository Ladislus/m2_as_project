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

    private val _cache = mutableMapOf<Node, String>()

    override fun visit(program: Program): String {
        return this._cache.getOrPut(program) {
            var result = "PROGRAM ${program._identifier?.let { "identifier(${it})" } ?: ""}\n"
            program._procedures.forEach { result += it.accept(this) + "\n" }
            result += "BEGIN\n"
            program._variables.forEach { result += it.accept(this) + "\n" }
            program._statements.forEach { result += it.accept(this) + "\n" }
            result += "END"

            result
        }
    }

    override fun visit(procedure: Procedure): String {
        return this._cache.getOrPut(procedure) {
            var result = "PROCEDURE identifier(${procedure._name})("
            result += procedure._variables.joinToString(", ") { it.accept(this) }
            procedure._return?.let { result += ", RES " + it.accept(this) }
            result += ")\nBEGIN\n"
            procedure._statements.forEach { result += "\t" + it.accept(this) + "\n"}

            result
        }
    }

    override fun visit(type: Type) =
        this._cache.getOrPut(type) { "TYPE(${type.type._representation})" }

    override fun visit(position: Position) =
        "POSITION(${position._line}, ${position._column})"

    override fun visit(block: Block) =
        this._cache.getOrPut(block) { "BLOCK(${block._statements.joinToString("\n") { it.accept(this) }})" }

    override fun visit(variable: Variable) =
        this._cache.getOrPut(variable) { "VARIABLE(${variable._type.accept(this)} identifier(${variable._name}))" }

    override fun visit(variableBlock: VariableBlock) =
        this._cache.getOrPut(variableBlock) {
            if (variableBlock._variables.isNotEmpty()) {
                "VARIABLEBLOCK(${variableBlock._variables.first()._type.accept(this)} ${variableBlock._variables.joinToString(", ") { it.accept(this) }}"
            } else "VARIABLEBLOCK()"
        }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) =
        this._cache.getOrPut(unaryArithmeticExpression) { "UNARYARITHMETICEXPRESSION(UNARYARITHMETICOPERATOR(${unaryArithmeticExpression._operator._representation}) ${unaryArithmeticExpression._expression.accept(this)})" }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) =
        this._cache.getOrPut(binaryArithmeticExpression) { "BINARYARITHMETICEXPRESSION(${binaryArithmeticExpression._leftExpression.accept(this)} BINARYARITHMETICOPERATOR(${binaryArithmeticExpression._operator._representation}) ${binaryArithmeticExpression._rightExpression.accept(this)})" }

    override fun visit(arithmeticConstant: ArithmeticConstant) =
        this._cache.getOrPut(arithmeticConstant) { "ARITHMETICCONSTANT(${arithmeticConstant._value})" }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression) =
        this._cache.getOrPut(arithmeticIdentifierExpression) { "ARITHMETICIDENTIFIEREXPRESSION(identifier(${arithmeticIdentifierExpression._identifier}))" }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression) =
        this._cache.getOrPut(unaryBooleanExpression) { "UNARYBOOLEANEXPRESSION(UNARYBOOLEANOPERATOR(${unaryBooleanExpression._operator._representation}) ${unaryBooleanExpression._expression.accept(this)})" }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression) =
        this._cache.getOrPut(binaryBooleanExpression) { "BINARYBOOLEANEXPRESSION(${binaryBooleanExpression._leftExpression.accept(this)} BINARYBOOLEANOPERATOR(${binaryBooleanExpression._operator._representation}) ${binaryBooleanExpression._rightExpression.accept(this)})" }

    override fun visit(booleanConstant: BooleanConstant) =
        this._cache.getOrPut(booleanConstant) { "BOOLEANCONSTANT(${booleanConstant._value})" }

    override fun visit(assignStatement: AssignStatement) =
        this._cache.getOrPut(assignStatement) { "ASSIGNSTATEMENT(identifier(${assignStatement._variableName}, ${assignStatement._value.accept(this)})" }

    override fun visit(callStatement: CallStatement) =
        this._cache.getOrPut(callStatement) { "CALLSTATEMENT(identifier(${callStatement._procedureName}, ${callStatement._arguments.joinToString(", ") { it.accept(this) }})" }

    override fun visit(ifStatement: IfStatement) =
        this._cache.getOrPut(ifStatement) { "IFSTATEMENT(${ifStatement._condition.accept(this)} ${ifStatement._thenBody.accept(this)} ${ifStatement._elseBody?.accept(this) ?: ""})" }

    override fun visit(skipStatement: SkipStatement) =
        this._cache.getOrPut(skipStatement) { "SKIPSTATEMENT" }

    override fun visit(whileStatement: WhileStatement) =
        this._cache.getOrPut(whileStatement) { "WHILESTATEMENT(${whileStatement._condition.accept(this)}, ${whileStatement._body.accept(this)})" }
}