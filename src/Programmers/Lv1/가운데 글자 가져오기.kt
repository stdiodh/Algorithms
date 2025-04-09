package Programmers.Lv1

class `가운데글자가져오기` {
    fun solution(s: String): String {
        var answer = ""
        if(s.length % 2 == 0){
            answer += s.slice(s.length / 2 - 1 .. s.length / 2)
        } else {
            answer += s.slice(s.length / 2 .. s.length / 2)
        }
        return answer
    }
}

fun main(){
    val n = 가운데글자가져오기()
    println(n.solution("qwer"))
}