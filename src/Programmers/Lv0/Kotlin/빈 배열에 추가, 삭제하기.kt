package Programmers.Lv0.Kotlin

class `빈배열에추가삭제하기` {
    fun solution(arr: IntArray, flag: BooleanArray): List<Int> {
        val answer = mutableListOf<Int>()
        for(i in arr.indices){
            if(flag[i]){
                repeat(arr[i] * 2){
                    answer.add(arr[i])
                }
            } else {
                repeat(arr[i]){
                    answer.removeLast()
                }
            }
        }

        return answer
    }
}

fun main() {
    val s = 빈배열에추가삭제하기()
    val arr = intArrayOf(3, 2, 4, 1, 3)
    val boolArr = booleanArrayOf(true, false, true, false, false)

    println(s.solution(arr, boolArr).toList())
}