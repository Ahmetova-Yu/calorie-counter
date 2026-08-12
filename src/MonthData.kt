class MonthData {
    val days = MutableList(30) { 0 }

    fun printDaysAndStepsFromMonth() {
        println("Количество пройденных шагов по дням: ")

        days.forEachIndexed { index, steps ->
            println("${index + 1} день: $steps")
        }
    }

    fun sumStepsFromMonth() :Int = days.sum()

    fun maxSteps() :Int = days.maxOrNull() ?: 0

    fun bestSeries(goalByStepsPerDay :Int) :Int {
        var count = 0
        var maxCount = 0

        days.forEach { steps ->
            if (steps >= goalByStepsPerDay) {
                count++
                maxCount = maxOf(maxCount, count)
            } else {
                count = 0
            }
        }

        return maxCount
    }
}