package BOJ.queue

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }

    val n = int()
    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()

    repeat(n){
        val cmd = int()
        when(cmd){
            1 -> {
                val num = int()
                deque.addFirst(num)
            }
            2 -> {
                val num = int()
                deque.addLast(num)
            }
            3 -> {
                if(deque.isNotEmpty()){
                    val first = deque.removeFirst()
                    sb.appendLine(first)
                } else {
                    sb.appendLine(-1)
                }
            }
            4 -> {
                if(deque.isNotEmpty()){
                    val last = deque.removeLast()
                    sb.appendLine(last)
                } else {
                    sb.appendLine(-1)
                }
            }
            5 -> {
                sb.appendLine(deque.size)
            }
            6 -> {
                sb.appendLine(if(deque.isEmpty()) 1 else 0)
            }
            7 -> {
                if(deque.isNotEmpty()){
                    val first = deque.removeFirst()
                    sb.appendLine(first)
                    deque.addFirst(first)
                } else {
                    sb.appendLine(-1)
                }
            }
            8 -> {
                if(deque.isNotEmpty()){
                    val last = deque.removeLast()
                    sb.appendLine(last)
                    deque.addLast(last)
                } else {
                    sb.appendLine(-1)
                }
            }
        }
    }
    println(sb)
}