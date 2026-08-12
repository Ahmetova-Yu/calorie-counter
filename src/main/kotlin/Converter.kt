class Converter {
    val STEP_TO_SM = 75
    val SM_TO_M = 100
    val M_TO_KM = 1000
    val STEP_TO_KAL = 50
    val KAL_TO_KKAL = 1000

    fun convertToKm(steps :Int) :Int {
        val steps_sm = STEP_TO_SM * steps
        val steps_m = steps_sm / SM_TO_M

        return steps_m / M_TO_KM
    }

    fun convertStepsToKilocalories(steps :Int) :Int {
        val steps_kal = STEP_TO_KAL * steps
        return steps_kal / KAL_TO_KKAL
    }
}