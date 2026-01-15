package Programmers.Kotlin

class `제일작은수제거하기` {
    fun solution(arr: IntArray): IntArray {
        if(arr.size == 1){
            return intArrayOf(-1)
        }
        var cnt = arr.first()
        for(i in arr){
            cnt = minOf(cnt, i)
        }
        val answer = arr.filter { it != cnt }
        return answer.toIntArray()
    }
}

fun main(){
    val n = 제일작은수제거하기()
    println(n.solution(intArrayOf(4,3,2,1)).toList())
}