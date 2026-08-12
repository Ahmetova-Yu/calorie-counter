class SleepTracker() {
    private val _monthToData = Array(12) { MonthData() }
    private var _goalByStepsPerDay :Int = 10_000
    private val converter = Converter()

    var goalByStepsPerDay: Int
            get() = _goalByStepsPerDay
            set(value) {
                if (value <= 0) {
                    println("Количество шагов должно быть больше 0")
                    return
                }
                _goalByStepsPerDay = value
            }

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

    fun inputDataAndValid() : Triple<Int, Int, Int>? {
        println("Введите номер месяца(1-12): ")
        val numOfMonth = readlnOrNull()?.toIntOrNull()
        if (numOfMonth == null || numOfMonth !in 1..12) {
            println("Номер вводимого месяца должен быть от 1 до 12 включительно")
            return null
        }

        println("Введите номер дня(1-30): ")
        val numOfDay = readlnOrNull()?.toIntOrNull()
        if (numOfDay == null || numOfDay !in 1..30) {
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

    fun printStatistic() {
        println("Введите номер месяца(1-12): ")
        val numOfMonth = readlnOrNull()?.toIntOrNull()
        if (numOfMonth == null || numOfMonth !in 1..12) {
            println("Номер вводимого месяца должен быть от 1 до 12 включительно")
            return
        }

        val monthData : MonthData = _monthToData[numOfMonth.minus(1)]

        println("Количество пройденных шагов по дням: ")
        monthData.printDaysAndStepsFromMonth()

        val sum = monthData.sumStepsFromMonth()
        println("\nОбщее количество шагов за месяц: ${sum}")

        println("Максимальное пройденное количество шагов в месяце: ${monthData.maxSteps()}")

        println("Среднее кол-во шагов: ${monthData.days.average()}")

        println("Пройденная дистанция (в километрах): ${converter.convertToKm(sum)}")

        println("Количество сожжённых килокалорий: ${converter.convertStepsToKilocalories(sum)}")

        println("Лучшая серия: ${monthData.bestSeries(_goalByStepsPerDay)}")
    }
}