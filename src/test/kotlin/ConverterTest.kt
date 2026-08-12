import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ConverterTest {
    private lateinit var converter: Converter

    @BeforeEach
    fun setUp() {
        converter = Converter()
    }

    @Test
    fun `should return correctly value to convert to km`() {
        val steps = converter.convertToKm(2000)
        assertEquals(1, steps)
    }

    @Test
    fun `should return 0 for 0 steps`() {
        val steps = converter.convertToKm(0)
        assertEquals(0, steps)
    }

    @Test
    fun `should return correctly value to convert kkl`() {
        val steps = converter.convertStepsToKilocalories(2000)
        assertEquals(100, steps)
    }

    @Test
    fun `should return 0 value to convert kkl`() {
        val steps = converter.convertStepsToKilocalories(0)
        assertEquals(0, steps)
    }
}