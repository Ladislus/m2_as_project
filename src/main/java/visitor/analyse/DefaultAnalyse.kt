package visitor.analyse

import ast.*
import ast.expression.*
import ast.expression.arithmetic.ArithmeticConstant
import ast.expression.bool.BooleanConstant
import ast.statement.*
import visitor.DefaultVisitor
import visitor.flow.Flow
import visitor.flow.IFlow

abstract class DefaultAnalyse<T>(
    protected val _flow: IFlow
): IAnalyse, DefaultVisitor<T>()