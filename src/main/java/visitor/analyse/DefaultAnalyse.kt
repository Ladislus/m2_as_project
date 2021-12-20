package visitor.analyse

import visitor.DefaultVisitor
import visitor.flow.IFlow

abstract class DefaultAnalyse<T>(
    protected val _flow: IFlow
): IAnalyse, DefaultVisitor<T>()