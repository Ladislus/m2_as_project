package visitor.analyse

import ast.*
import ast.declaration.Variable
import ast.declaration.VariableBlock
import ast.statement.*
import visitor.DefaultVisitor
import visitor.raiseIllegalStateExceptionWithClass
import java.lang.UnsupportedOperationException

abstract class DefaultKiller<T>: DefaultVisitor<T>() {
    override fun visit(program: Program): T {
        raiseIllegalStateExceptionWithClass(program::class.java)
    }

    override fun visit(procedure: Procedure): T {
        raiseIllegalStateExceptionWithClass(procedure::class.java)
    }

    override fun visit(type: Type): T {
        raiseIllegalStateExceptionWithClass(type::class.java)
    }

    override fun visit(position: Position): T {
        raiseIllegalStateExceptionWithClass(position::class.java)
    }

    override fun visit(block: Block): T {
        raiseIllegalStateExceptionWithClass(block::class.java)
    }

    override fun visit(variable: Variable): T {
        raiseIllegalStateExceptionWithClass(variable::class.java)
    }

    override fun visit(variableBlock: VariableBlock): T {
        raiseIllegalStateExceptionWithClass(variableBlock::class.java)
    }

    override fun visit(assignStatement: AssignStatement): T {
        raiseIllegalStateExceptionWithClass(assignStatement::class.java)
    }

    override fun visit(callStatement: CallStatement): T {
        raiseIllegalStateExceptionWithClass(callStatement::class.java)
    }

    override fun visit(ifStatement: IfStatement): T {
        raiseIllegalStateExceptionWithClass(ifStatement::class.java)
    }

    override fun visit(skipStatement: SkipStatement): T {
        raiseIllegalStateExceptionWithClass(skipStatement::class.java)
    }

    override fun visit(whileStatement: WhileStatement): T {
        throw UnsupportedOperationException("Method should not be called")
    }
}