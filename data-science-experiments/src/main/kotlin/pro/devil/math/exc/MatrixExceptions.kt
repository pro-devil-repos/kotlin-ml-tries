package pro.devil.math.exc

open class MathMatrixException(message: String?, cause: Throwable?) : RuntimeException(message, cause) {
    constructor() : this(null, null)
}

class MatrixDimensionsException(message: String?, cause: Throwable?) : MathMatrixException(message, cause) {
    constructor() : this(null, null)
    constructor(message: String) : this(message, null)
}