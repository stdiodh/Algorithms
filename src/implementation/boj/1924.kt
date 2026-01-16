import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt(): Int { nextToken(); return nval.toInt() }

    val month = readInt()
    val day = readInt()

    val dayOfWeekName = if (month == 1) {
        getDayOfWeekName(day % 7)
    } else {
        getDayOfWeekName((getAccumulatedDays(month - 1) + day) % 7)
    }

    print(dayOfWeekName)
}

fun getAccumulatedDays(month: Int): Int {
    return when(month) {
        1 -> 31
        2 -> 59
        3 -> 90
        4 -> 120
        5 -> 151
        6 -> 181
        7 -> 212
        8 -> 243
        9 -> 273
        10 -> 304
        11 -> 334
        12 -> 365
        else -> 0
    }
}

fun getDayOfWeekName(dayIndex: Int): String {
    return when(dayIndex) {
        1 -> "MON"
        2 -> "TUE"
        3 -> "WED"
        4 -> "THU"
        5 -> "FRI"
        6 -> "SAT"
        0 -> "SUN"
        else -> ""
    }
}
