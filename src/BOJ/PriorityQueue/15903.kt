package BOJ.PriorityQueue

import java.io.StreamTokenizer
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Long { nextToken(); return nval.toLong()}

    val n = i(); val m = i()
    var rnt = 0L
    val heapq = PriorityQueue<Long>()

    repeat(n.toInt()){
        val num = i()
        heapq.add(num)
    }

    repeat(m.toInt()){
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