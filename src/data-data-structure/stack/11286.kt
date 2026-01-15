package BOJ.stack

import java.io.StreamTokenizer
import java.util.PriorityQueue
import kotlin.math.abs

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val priorityQueue = PriorityQueue<Int>{ a, b ->
        val absA = abs(a)
        val absB = abs(b)
        when {
            absA != absB -> absA - absB
            a != b -> a - b
            else -> 0
        }
    }
    val sb = StringBuilder()

    repeat(n){
        val num = i()
        if(num == 0){
            if(priorityQueue.isEmpty()){
                sb.appendLine(0)
            } else {
                sb.appendLine(priorityQueue.poll())
            }
        } else {
            priorityQueue.add(num)
        }
    }
    print(sb)
}