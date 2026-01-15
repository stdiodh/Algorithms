package BOJ.PriorityQueue

import java.io.StreamTokenizer
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }
    fun l() : Long { nextToken(); return nval.toLong() }

    val n = i(); val m = i()
    var rnt = 0L
    val heapq = PriorityQueue<Long>()

    repeat(n){
        val num = l()
        heapq.add(num)
    }

    repeat(m){
        var sum = 0L
        repeat(2){
            val minCard = heapq.poll()
            sum += minCard
        }
        repeat(2){
            heapq.add(sum)
        }
    }

    while(heapq.isNotEmpty()){
        val card = heapq.poll()
        rnt += card
    }

    print(rnt)
}