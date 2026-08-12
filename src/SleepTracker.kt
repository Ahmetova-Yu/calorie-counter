import java.time.Month
import java.util.Scanner

class SleepTracker(private val scanner: Scanner) {
    private val _monthToData = Array(12) { MonthData() }

    val monthToData: List<MonthData>
        get() = _monthToData.toList()

    fun addNewNumberStepsPerDay() {
        val inputData = inputDataAndValid()
        if (inputData == null) {
            println("Ошибка ввода. Попробуйте снова")
            return
        }

        val (numOfMonth, numOfDay, numOfSteps) = inputData

        val monthData : MonthData = _monthToData[numOfMonth.minus(1)]
        monthData.days[numOfDay.minus(1)] = numOfSteps
        println("Шаги сохранены!")
    }

    private fun inputDataAndValid() : Triple<Int, Int, Int>? {
        println("Введите номер месяца(1-12): ")
        val numOfMonth = readlnOrNull()?.toIntOrNull()
        if (numOfMonth == null || numOfMonth !in 0..13) {
            println("Номер вводимого месяца должен быть от 1 до 12 включительно")
            return null
        }

        println("Введите номер дня(1-30): ")
        val numOfDay = readlnOrNull()?.toIntOrNull()
        if (numOfDay == null || numOfDay !in 0..31) {
            println("Номер вводимого дня должен быть от 1 до 30 включительно")
            return null
        }

        println("Введите количество шагов(положительное число): ")
        val numOfSteps = readlnOrNull()?.toIntOrNull()
        if (numOfSteps == null || numOfSteps < 0) {
            println("Количество шагов должно быть положительным числом")
            return null

        }

        return Triple(numOfMonth, numOfDay, numOfSteps)
    }
}