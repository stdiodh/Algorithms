package BOJ.stack

import java.io.StreamTokenizer
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i(): Int {
        nextToken(); return nval.toInt()
    }

    val n = i()
    val queue = LinkedList<Int>()

    repeat(n) {
        queue.add(it + 1)
    }

    while(queue.size > 1){
        queue.poll()
        queue.add(queue.poll())
    }
    print(queue.poll())
}

