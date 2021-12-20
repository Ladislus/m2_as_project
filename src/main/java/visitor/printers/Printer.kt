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

class Printer: DefaultVisitor<String>() {

    private val _cache = mutableMapOf<Node, String>()

    override fun visit(program: Program): String {
        return this._cache.getOrPut(program) {
            var result = "program ${program._identifier ?: ""}\n"
            program._procedures.forEach { result += it.accept(this) + "\n" }
            result += "begin\n"
            program._variables.forEach { result += it.accept(this) + "\n" }
            program._statements.forEach { result += it.accept(this) + "\n"}
            result += "end\n"

            result
        }
    }

    override fun visit(procedure: Procedure): String {
        return this._cache.getOrPut(procedure) {
            var result = "procedure ${procedure._name}("
            result += procedure._variables.joinToString(", ") { it.accept(this) }
            procedure._return?.let { result += ", res " + it.accept(this) }
            result += ")\nbegin\n"
            procedure._statements.forEach { result += "\t" + it.accept(this) + "\n" }
            result += "end"

            result
        }
    }

    override fun visit(type: Type) =
        this._cache.getOrPut(type) {
            type.type._representation
        }

    override fun visit(position: Position) =
        "Position(${position._line}, ${position._column})"

    override fun visit(variable: Variable) =
        this._cache.getOrPut(variable) { "${variable._type.accept(this)} ${variable._name}${variable._expression?.let { " := " + it.accept(this) } ?: ""}" }

    override fun visit(variableBlock: VariableBlock) =
        this._cache.getOrPut(variableBlock) {
            if (variableBlock._variables.isEmpty()) {
                ""
            } else {
                "${variableBlock._variables.first()._type.accept(this)} ${variableBlock._variables.joinToString(", ") { variable ->
                    variable._name + (variable._expression?.let { expression ->
                        " ${expression.accept(this)}"
                    } ?: "")
                }};"
            }
        }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) =
        this._cache.getOrPut(unaryArithmeticExpression) { "${unaryArithmeticExpression._operator._representation} ${unaryArithmeticExpression._expression.accept(this)}" }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) =
        this._cache.getOrPut(binaryArithmeticExpression) { "${binaryArithmeticExpression._leftExpression.accept(this)} ${binaryArithmeticExpression._operator._representation} ${binaryArithmeticExpression._rightExpression.accept(this)}" }

    override fun visit(arithmeticConstant: ArithmeticConstant) =
        this._cache.getOrPut(arithmeticConstant) { arithmeticConstant._value.toString() }

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression) =
        this._cache.getOrPut(arithmeticIdentifierExpression) { arithmeticIdentifierExpression._identifier }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression) =
        this._cache.getOrPut(unaryBooleanExpression) { "${unaryBooleanExpression._operator._representation} ${unaryBooleanExpression._expression.accept(this)}" }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression) =
        this._cache.getOrPut(binaryBooleanExpression) { "${binaryBooleanExpression._leftExpression.accept(this)} ${binaryBooleanExpression._operator._representation} ${binaryBooleanExpression._rightExpression.accept(this)}" }

    override fun visit(booleanConstant: BooleanConstant) =
        this._cache.getOrPut(booleanConstant) { booleanConstant._value.toString() }

    override fun visit(assignStatement: AssignStatement) =
        this._cache.getOrPut(assignStatement) { "${assignStatement._variableName} := ${assignStatement._value.accept(this)};" }

    override fun visit(callStatement: CallStatement) =
        this._cache.getOrPut(callStatement) { "call ${callStatement._procedureName}${callStatement._arguments.joinToString(", ", prefix = "(", postfix = ")") { it.accept(this) }}" }

    override fun visit(ifStatement: IfStatement) =
        this._cache.getOrPut(ifStatement) { "if (${ifStatement._condition.accept(this)}) then\n${ifStatement._thenBody.accept(this)}\n${ifStatement._elseBody?.let { "else\n" + it.accept(this) }}" }

    override fun visit(skipStatement: SkipStatement) =
        this._cache.getOrPut(skipStatement) { "skip" }

    override fun visit(whileStatement: WhileStatement) =
        this._cache.getOrPut(whileStatement) { "while (${whileStatement._condition.accept(this)}) do (\n${whileStatement._body.accept(this)}\n)" }

    override fun visit(block: Block): String =
        this._cache.getOrPut(block) { block._statements.joinToString("\n") { "\t" + it.accept(this) } }
}

