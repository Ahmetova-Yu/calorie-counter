import java.util.Scanner

class SleepTracker(private val scanner: Scanner) {
    private val _monthToData = Array(12) { MonthData() }

    val monthToData: List<MonthData>
        get() = _monthToData.toList()


}