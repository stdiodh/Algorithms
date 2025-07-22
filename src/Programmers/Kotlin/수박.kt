package Programmers.Kotlin

class 수박 {
    fun solution(n: Int): String {
        var answer = ""
        repeat(n){
            if(it % 2 == 0){
                answer += "수"
            } else {
                answer += "박"
            }
        }
        return answer
    }
}