class MonthData {
    val days = MutableList(30) { 0 }

    fun printDaysAndStepsFromMonth() {
        days.forEachIndexed { index, steps ->
            println("${index + 1} день: $steps")
        }
    }

    fun sumStepsFromMonth() :Int {
        return days.sum()
    }

    fun maxSteps() :Int {
        return days.maxOrNull() ?: 0
    }

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