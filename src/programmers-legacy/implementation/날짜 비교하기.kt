package Programmers.Kotlin

class `날짜비교하기` {
    fun solution(date1: IntArray, date2: IntArray): Int {
        if(date1[0] * 365 + date1[1] * 30 + date1[2] < date2[0] * 365 + date2[1] * 30 + date2[2]){
            return 1
        }

        return 0
    }
}

fun main() = with((System.`in`.bufferedReader())){
    val i = 날짜비교하기()

    val date1 = readLine().split(" ").map { it.toInt() }.toIntArray()
    val date2 = readLine().split(" ").map { it.toInt() }.toIntArray()

    println(i.solution(date1, date2))
}