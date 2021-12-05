package visitor.flow

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

class ForwardFlow(val _flow: MutableMap<Node, MutableList<Node>>): DefaultVisitor<List<Node>>() {

    override fun visit(program: Program): List<Node> {

        // TODO PROCEDURE MAGGLE

        // Variable
        for (i in 0 until program._variables.size - 1) {
            val sucessor = program._variables[i + 1]
            program._variables[i].accept(this).forEach { this._flow[it]?.add(sucessor) ?: mutableListOf(sucessor) }
        }

        // First statement is the successor of the last variable
        if (program._statements.isNotEmpty() && program._variables.isNotEmpty()) {
            val sucessor = program._statements.first()
            program._variables.last().accept(this).forEach { this._flow[it]?.add(sucessor) ?: mutableListOf(sucessor) }
        }

        // Statements
        for (i in 0 until program._statements.size - 1) {

            val successor = program._statements[i + 1]
            program._statements[i].accept(this).forEach {
                predecessor ->
                    this._flow[predecessor]?.add(successor) ?: mutableListOf(successor)
            }

        }

        return emptyList()
    }

    override fun visit(procedure: Procedure) {
        for (i in 0 until procedure._variables.size - 1) {

            procedure._variables[i].accept(this)
        }
    }

    override fun visit(type: Type) {}

    override fun visit(position: Position) {}

    override fun visit(block: Block) {
        for (i in 0 until block._statements.size - 1) {
            flow[block._statements[i]] = mutableListOf(block._statements[i + 1])
            block._statements[i].accept(this)
        }
    }

    override fun visit(variable: Variable) {}

    override fun visit(variableBlock: VariableBlock) {
        for (i in 0 until variableBlock._variables.size - 1)
            flow[variableBlock._variables[i]] = mutableListOf(variableBlock._variables[i + 1])
    }

    override fun visit(unaryArithmeticExpression: UnaryArithmeticExpression) {}

    override fun visit(binaryArithmeticExpression: BinaryArithmeticExpression) {}

    override fun visit(arithmeticConstant: ArithmeticConstant) {}

    override fun visit(arithmeticIdentifierExpression: IdentifierExpression) {}

    override fun visit(unaryBooleanExpression: UnaryBooleanExpression) {}

    override fun visit(binaryBooleanExpression: BinaryBooleanExpression) {}

    override fun visit(booleanConstant: BooleanConstant) {}

    override fun visit(assignStatement: AssignStatement) {}

    override fun visit(callStatement: CallStatement) {
        TODO("Not yet implemented")
    }

    override fun visit(ifStatement: IfStatement) {

    }

    override fun visit(skipStatement: SkipStatement) {}

    override fun visit(whileStatement: WhileStatement) =
        whileStatement._body.accept(this)
}