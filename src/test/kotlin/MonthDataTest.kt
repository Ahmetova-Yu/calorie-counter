import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MonthDataTest {
    private lateinit var monthData: MonthData

    @BeforeEach
    fun setUp() {
        monthData = MonthData()
    }

    @Test
    fun `should add step to correctly day`() {
        monthData.days[0] = 1000

        assertEquals(1000, monthData.days[0])
    }

    @Test
    fun `should return 0 for day without steps`() {
        assertEquals(0, monthData.days[4])
    }

    @Test
    fun `should return correctly sum`() {
        monthData.days[0] = 1000
        monthData.days[1] = 2000
        monthData.days[2] = 3000

        assertEquals(6000, monthData.sumStepsFromMonth())
    }

    @Test
    fun `should return 0 - sum for month without steps`() {
        assertEquals(0, monthData.sumStepsFromMonth())
    }

    @Test
    fun `should return correctly max value`() {
        monthData.days[0] = 1000
        monthData.days[1] = 2000
        monthData.days[2] = 3000

        assertEquals(3000, monthData.maxSteps())
    }

    @Test
    fun `should return 0 - max value for month without steps`() {
        assertEquals(0, monthData.maxSteps())
    }

    @Test
    fun `should return correctly best series`() {
        monthData.days[0] = 1000
        monthData.days[1] = 20_000
        monthData.days[2] = 30_000

        assertEquals(2, monthData.bestSeries(10_000))
    }

    @Test
    fun `should return 0 best series for month without steps`() {
        assertEquals(0, monthData.bestSeries(10_000))
    }
}