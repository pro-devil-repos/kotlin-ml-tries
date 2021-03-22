package pro.devil.math

import pro.devil.math.exc.MatrixDimensionsException

/**
 * Числовые матрицы
 */
class Matrix<T : Number>(
    x: Int,
    y: Int
) {

    var x: Int = 0
        private set
    var y: Int = 0
        private set

    private val matrix = mutableListOf<Vector<T>>()

    fun add(vector: Vector<T>) {
        // Если первая строка добавляется, то выставляем размерность X
        if (x == 0) {
            x = vector.size
        }

        // Проверим, что все вектора одной размерности
        if (vector.size != x) {
            throw MatrixDimensionsException("All rows in matrix have to be one size (given ${vector.size} in row ${y + 1}, but need $x")
        }

        this.matrix.add(vector)
        y++
    }

    override fun toString() = matrix.toString()
}

fun <T : Number> matrixOf(vararg vectors: Vector<T>): Matrix<T> {
    val resultMatrix = Matrix<T>(vectors[0].size, vectors.size)
    vectors.forEach { resultMatrix.add(it) }

    return resultMatrix
}