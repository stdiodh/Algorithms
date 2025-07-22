package Programmers.Kotlin

class `문자열뒤집기` {
    fun solution(my_string: String, s: Int, e: Int): String {
        var answer: String = my_string.substring(s, e+1)
        return my_string.replace(answer, answer.reversed())
    }
}

fun main(){
    val i = 문자열뒤집기()
    val myString = "Progra21Sremm3"
    println(i.solution(myString, 6, 12))
}