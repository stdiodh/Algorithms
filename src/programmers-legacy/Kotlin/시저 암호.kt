package Programmers.Kotlin

class `시저암호` {
    fun solution(s: String, n: Int): String {
        var answer = ""
        s.forEach{
            answer += when (it) {
                ' ' -> ' '
                in 'a' .. 'z' -> {
                    val shift = (it - 'a' + n) % 26 + 'a'.code
                    shift.toChar()
                }
                in 'A' .. 'Z' -> {
                    val shift = (it - 'A' + n) % 26 + 'A'.code
                    shift.toChar()
                }
                else -> it
            }
        }
        return answer
    }
}

fun main(){
    val f = 시저암호()
    println(f.solution("a B z", 4))
}