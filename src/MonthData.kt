class MonthData {
    private val _days = MutableList(30) { 0 }

    val days: List<Int>
        get() = _days.toList()
}