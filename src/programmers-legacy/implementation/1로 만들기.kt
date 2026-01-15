package Programmers.Kotlin

class `일로만들기` {
    fun solution(num_list: IntArray): Int {
        var cnt: Int = 0
        for(x in num_list){
            var num = x
            while(num != 1){
                cnt++
                if(num % 2 == 0){
                    num /= 2
                } else {
                    num = (num - 1) / 2
                }
            }
        }
        return cnt
    }
}

fun main(){
    val i = Programmers.Kotlin.일로만들기()
    val numList = intArrayOf(12, 4, 15, 1, 14)
    println(i.solution(numList))
}