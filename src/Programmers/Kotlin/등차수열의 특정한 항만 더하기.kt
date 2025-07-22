package Programmers.Kotlin

class `등차수열의특정한항만더하기` {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var cnt = a
        var answer = 0
        for (x in included.indices) {
            if (included[x]) {
                answer += cnt
            }
            cnt += d
        }
        return answer
    }
}

fun main(){
    val s = 등차수열의특정한항만더하기()
    val included = booleanArrayOf(true, false, false, true, true)
    println(s.solution(3, 4, included))
}