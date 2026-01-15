package BOJ.Structure

import java.io.StreamTokenizer
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val heap = PriorityQueue<Int>()
    repeat(n){
        val num = nextInt()
        heap.add(num)
    }

    var sum = 0
    while(heap.size > 1){
        sum += (heap.poll() + heap.poll()).also { heap.add(it) }
    }
    print(sum)
}