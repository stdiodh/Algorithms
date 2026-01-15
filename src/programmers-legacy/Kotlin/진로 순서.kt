package Programmers.Kotlin

import java.util.Collections
import java.util.PriorityQueue

class `진로순서` {
    fun solution(emergency: IntArray): MutableList<Int> {
        var answer: MutableList<Int> = mutableListOf<Int>()
        val sortArr = emergency.sortedArrayDescending()
        repeat(emergency.size){ i ->
            val num = emergency[i]

            repeat(sortArr.size){ j ->
                if(num == sortArr[j]){
                    answer.add(j + 1)
                }
            }
        }
        return answer
    }
}

fun main() {
    val s = 진로순서()
    s.solution(intArrayOf(3, 76, 24))
}