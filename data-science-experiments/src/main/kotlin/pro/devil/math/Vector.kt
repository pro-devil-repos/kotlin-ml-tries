package pro.devil.math

/**
 * Вектор числовых значений
 */
class Vector<T : Number>(vararg elements: T) {
    var size: Int = 0
        private set

    private val vector: MutableList<T> = mutableListOf()

    init {
        elements.forEach { this.add(it) }
    }


    private fun add(element: T) {
        vector.add(element)
        size++
    }

    override fun toString() = vector.toString()
}

fun <T : Number> vectorOf(vararg elements: T) = Vector<T>(*elements)