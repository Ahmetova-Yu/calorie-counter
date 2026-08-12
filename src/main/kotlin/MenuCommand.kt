enum class MenuCommand(val num: Int, val description: String) {
    ADD_STEPS(1, "ввести количество шагов за определённый день"),
    CHANGE_GOAL(2, "изменить цель по количеству шагов в день"),
    STATISTICS(3, "напечатать статистику за определённый месяц"),
    EXIT(4, "выйти из приложения");

    companion object {
        fun fromInt(value: Int): MenuCommand? {
            return entries.find{it.num == value}
        }
    }
}