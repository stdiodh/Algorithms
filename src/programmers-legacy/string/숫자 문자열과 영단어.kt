package Programmers.Kotlin

class `숫자문자열과영단어` {
    fun solution(s: String): Int {
        var answer = s
        val strArr = arrayOf(
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
        )

        repeat(10){
            answer = answer.replace(strArr[it], it.toString())
        }

        return answer.toInt()
    }
}

fun main(){
    val f = 숫자문자열과영단어()
    println(f.solution("one4seveneight"))
}