package BOJ.PriorityQueue

import java.io.StreamTokenizer
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val heapq = PriorityQueue<Int>()

    repeat(n){
        heapq.add(i())
    }

    var ans = 0
    repeat(n-1){
        val total = heapq.poll() + heapq.poll()
        ans += total
        heapq.add(total)
    }
    print(ans)
}