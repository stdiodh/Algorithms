package BOJ.queue

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }

    val n = int()
    val deque = ArrayDeque<Pair<Int, Int>>() // index, move

    for(i in 1..n){
        val move = int()
        deque.add(Pair(i, move))
    }

    val result = mutableListOf<Int>()

    while(deque.isNotEmpty()){
        val (idx, move) = deque.removeFirst()
        result.add(idx)

        if(deque.isEmpty()) break

        if(move > 0){
            repeat(move - 1) { deque.addLast(deque.removeFirst())}
        } else {
            repeat(-move) { deque.addFirst(deque.removeLast()) }
        }
    }

    println(result.joinToString(" "))
}