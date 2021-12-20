package visitor.analyse.reachingDefinition

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

class ReachingDefinitionFinder(
    _program: Program
): DefaultVisitor<Unit>() {

    val _identifiers: MutableSet<String> = mutableSetOf()

    init {
        _program.accept(this)
    }

    override fun visit(program: Program) {
        program._procedures.forEach { it.accept(this) }
        program._variables.forEach { it.accept(this) }
        program._statements.forEach { it.accept(this) }
    }

    override fun visit(procedure: Procedure) {
        procedure._variables.forEach { it.accept(this) }
        procedure._return?.accept(this)
    }

    override fun visit(type: Type) {}

    override fun visit(position: Position) {}

    override fun visit(block: Block) {
        block._statements.forEach { it.accept(this) }
    }

    override fun visit(variable: Variable) {
        this._identifiers += variable._name
        variable._expression?.accept(this)
    }

    override fun visit(variableBlock: VariableBlock) {
        variableBlock._variables.forEach { it.accept(this) }
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) {
        unaryArithmeticExpression._expression.accept(this)
    }

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) {
        binaryArithmeticExpression._leftExpression.accept(this)
        binaryArithmeticExpression._rightExpression.accept(this)
    }

    override fun visit(arithmeticConstant: ArithmeticConstant) {}

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression) {
        this._identifiers += arithmeticIdentifierExpression._identifier
    }

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression) {
        unaryBooleanExpression._expression.accept(this)
    }

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression) {
        binaryBooleanExpression._leftExpression.accept(this)
        binaryBooleanExpression._rightExpression.accept(this)
    }

    override fun visit(booleanConstant: BooleanConstant) {}

    override fun visit(assignStatement: AssignStatement) {
        this._identifiers += assignStatement._variableName
        assignStatement._value.accept(this)
    }

    override fun visit(callStatement: CallStatement) {
        callStatement._arguments.forEach { it.accept(this) }
    }

    override fun visit(ifStatement: IfStatement) {
        ifStatement._condition.accept(this)
        ifStatement._thenBody.accept(this)
    }

    override fun visit(skipStatement: SkipStatement) {}

    override fun visit(whileStatement: WhileStatement) {
        whileStatement._condition.accept(this)
        whileStatement._body.accept(this)
    }
}