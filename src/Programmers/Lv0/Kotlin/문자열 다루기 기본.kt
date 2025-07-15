package Programmers.Lv0.Kotlin

class `문자열다루기기본` {
    fun solution(s: String): Boolean {
        return s.all { it.isDigit() } && ( s.length == 4 || s.length == 6 )
    }
}

fun main(){
    val n = 문자열다루기기본()
    println(n.solution("a234"))
}