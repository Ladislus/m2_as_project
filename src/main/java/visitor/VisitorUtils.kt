package visitor


fun <T> raiseIllegalStateExceptionWithClass(clazz: Class<T>): Nothing =
    throw IllegalStateException("Shouldn't be possible to reach visit(${clazz})")