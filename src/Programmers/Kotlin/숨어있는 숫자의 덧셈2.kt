package Programmers.Kotlin

class `숨어있는숫자의덧셈2` {
    fun solution(my_string: String): Int {
        var answer: Int = 0
        val regex = Regex("\\d+")
        val matches = regex.findAll(my_string)
        matches.forEach {
            answer += it.value.toInt()
        }
        return answer
    }
}

fun main(){
    val s = 숨어있는숫자의덧셈2()
    println(s.solution("aAb1B2cC34oOp"))
}