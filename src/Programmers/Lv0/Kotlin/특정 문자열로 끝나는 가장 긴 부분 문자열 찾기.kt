package Programmers.Lv0.Kotlin

class `특정문자열로끝나는가장긴부분문자열찾기` {
    fun solution(myString: String, pat: String): String {
        return myString.substringBeforeLast(pat) + pat
    }
}

fun main(){
    val i = 특정문자열로끝나는가장긴부분문자열찾기()
    val myString = "AAAAaaaa"
    println(i.solution(myString, "a"))
}