import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val x = i(); val y = i()
    val dayOfTheWeek = if(x == 1) {
        checkToDay(y % 7)
    } else {
        checkToDay((dayOfMonth(x - 1) + y) % 7)
    }

    print(dayOfTheWeek)
}

fun dayOfMonth(month: Int): Int {
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

fun checkToDay(day : Int) : String {
    return when(day) {
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