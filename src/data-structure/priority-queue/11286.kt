package BOJ.PriorityQueue

import java.io.StreamTokenizer
import java.util.PriorityQueue
import kotlin.math.abs

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val heapq = PriorityQueue<Int>(){ a, b ->
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
            if (heapq.isEmpty()){
                sb.appendLine(0)
            } else {
                sb.appendLine(heapq.poll())
            }
        } else {
            heapq.add(num)
        }
    }
    print(sb)
}