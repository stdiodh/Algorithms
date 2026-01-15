package BOJ.PriorityQueue

import java.io.StreamTokenizer
import java.util.Collections
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val heapq = PriorityQueue<Int>(Collections.reverseOrder())
    val sb = StringBuilder()

    repeat(n){
        val num = i()
        if(num > 0){
            heapq.add(num)
        } else if (num == 0 && heapq.isEmpty()){
            sb.appendLine(0)
        } else {
            sb.appendLine(heapq.poll())
        }
    }
    print(sb)
}