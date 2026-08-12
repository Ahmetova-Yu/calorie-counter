fun main() {
    println("Вас приветствует 'Счетчик калорий'")
    val sleepTracker = SleepTracker()

    while (true) {
        printMenu()

        val input = readlnOrNull()?.trim()
        if (input.isNullOrEmpty()) {
            println("Пожалуйста, введите номер команды")
            continue
        }

        val commandRange = 1..MenuCommand.entries.size
        val number = input.toIntOrNull()

        if (number == null) {
            println("Неизвестная команда: введите число от ${commandRange.first} до ${commandRange.last}")
            continue
        }

        val command = MenuCommand.fromInt(number)
        if (command == null) {
            println("Неизвестная команда: введите число от ${commandRange.first} до ${commandRange.last}")
            continue
        }

        when(command) {
            MenuCommand.ADD_STEPS -> sleepTracker.addNewNumberStepsPerDay()
            MenuCommand.CHANGE_GOAL -> {
                println("Введите новую цель: ")
                val goal = readlnOrNull()?.toIntOrNull()
                if (goal == null) {
                    println("Ошибка. Введите число")
                    continue
                }

                sleepTracker.goalByStepsPerDay = goal
                println("Цель изменена на $goal")
            }
            MenuCommand.STATISTICS -> sleepTracker.printStatistic()
            MenuCommand.EXIT -> {
                println("Выход")
                break
            }
        }
    }
}

fun printMenu() {
    println("\nВведите одну из команд: ")
    MenuCommand.entries.forEachIndexed { index, command ->
        println("${index + 1} - ${command.description}")
    }
}