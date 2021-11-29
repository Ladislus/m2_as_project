package visitor

import kotlin.reflect.KClass

fun raiseIllegalStateExceptionWithClass(clazz: KClass<*>): Nothing =
    throw IllegalStateException("Shouldn't be possible to reach visit(${clazz})")