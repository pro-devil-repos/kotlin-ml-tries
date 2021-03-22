package pro.devil.math

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import pro.devil.math.exc.MatrixDimensionsException
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MatrixTests {

    @Test
    fun test_Matrix_Created_Successfully_from_Vectors() {
        val vector1 = Vector<Int>(1, 2)
        val vector2 = Vector<Int>(3, 4)
        val vector3 = Vector<Int>(5, 6)

        val matrix = matrixOf(vector1, vector2, vector3)

        assertEquals(matrix.x, 2)
        assertEquals(matrix.y, 3)
    }

    @Test
    fun test_Matrix_Creation_Failed_When_Wrong_Dimensions() {
        val vector1 = Vector<Int>(1, 2)
        val vector2 = Vector<Int>(3, 4, 5)
        val vector3 = Vector<Int>(5, 6)

        assertThrows<MatrixDimensionsException> {
            val matrix = matrixOf(vector1, vector2, vector3)
        }
    }
}