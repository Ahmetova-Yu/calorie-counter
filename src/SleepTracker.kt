class SleepTracker() {
    private val _monthToData = Array(12) { MonthData() }
    private var _goalByStepsPerDay :Int = 10_000
    private val converter = Converter()

    val monthToData: List<MonthData>
        get() = _monthToData.toList()

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

    fun printStatistic() {
        println("Введите номер месяца(1-12): ")
        val numOfMonth = readlnOrNull()?.toIntOrNull()
        if (numOfMonth == null || numOfMonth !in 0..13) {
            println("Номер вводимого месяца должен быть от 1 до 12 включительно")
            return
        }

        val monthData : MonthData = _monthToData[numOfMonth.minus(1)]

        println("Количество пройденных шагов по дням: ")
        monthData.printDaysAndStepsFromMonth()

        println("Общее количество шагов за месяц")
        val sum = monthData.sumStepsFromMonth()
        print(sum)

        println("Максимальное пройденное количество шагов в месяце")
        print(monthData.maxSteps())

        println("Среднее кол-во шагов: ")
        println(sum / monthData.days.size)

        println("Пройденная дистанция (в километрах): ")
        print(converter.convertToKm(sum))

        println("Количество сожжённых килокалорий: ")
        print(converter.convertStepsToKilocalories(sum))

        println("Лучшая серия")
        print(monthData.bestSeries(_goalByStepsPerDay))
    }
}