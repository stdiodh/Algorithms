package Programmers.Lv0.Kotlin

class `수열과구간쿼리1` {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = arr
        for(x in queries){
            for(y in x[0] .. x[1]){
                answer[y] += 1
            }
        }
        return answer
    }
}

fun main(){
    val s = 수열과구간쿼리1()
    val arr = intArrayOf(0,1,2,3,4)
    val queries = arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(2,3))
    println(s.solution(arr, queries).toList())
}