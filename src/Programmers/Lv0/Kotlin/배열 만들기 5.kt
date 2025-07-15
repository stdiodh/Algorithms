package Programmers.Lv0.Kotlin

class `배열만들기5` {
    fun solution(intStrs: Array<String>, k: Int, s: Int, l: Int): List<Int> {
        var answer= mutableListOf<Int>()
        for(x in intStrs){
            val subStr = x.substring(s, s+l).toInt()
            if(subStr > k){
                answer.add(subStr)
            }
        }

        return answer
    }
}

fun main(){
    val s = 배열만들기5()
    val intStrs = arrayOf("0123456789","9876543210","9999999999999")
    println(s.solution(intStrs, 50000, 5, 5))

}