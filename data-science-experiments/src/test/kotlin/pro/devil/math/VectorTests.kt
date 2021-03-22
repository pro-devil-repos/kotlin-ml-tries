package pro.devil.math

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VectorTests {

    @Test
    fun test_Vectors_Created_Successfully() {
        val vector1 = Vector<Int>(1, 2)
        val vector2 = Vector<Double>(1.02, 2.04, 1.01)
        val vector3 = Vector<Float>(1f, 2f, 1.01f)
        val vector4 = vectorOf<Long>(1L, 2L, 5L)

        assertEquals(vector1.size, 2)
        assertEquals(vector2.size, 3)
        assertEquals(vector3.size, 3)
        assertEquals(vector4.size, 3)
    }
}