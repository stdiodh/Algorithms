package BOJ.PriorityQueue

import java.io.StreamTokenizer
import java.util.Collections
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }
    fun l() : Long { nextToken(); return nval.toLong() }

    val n = i()
    val heapq = PriorityQueue<Long>(Collections.reverseOrder())

    repeat(n*n){
        val num = l()
        heapq.add(num)
    }

    var rnt = 0L
    repeat(n){
        rnt = heapq.poll()
    }
    print(rnt)
}