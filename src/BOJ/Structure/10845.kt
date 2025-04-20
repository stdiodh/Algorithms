package BOJ.Structure

import java.io.StreamTokenizer
import java.util.LinkedList
import java.util.Queue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun next() : String { nextToken(); return sval }
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val queue : Queue<Int> = LinkedList()
    val sb = StringBuilder()

    repeat(n){
        val command = next()

        when(command){
            "push" -> {
                val num = nextInt()
                queue.add(num)
            }
            "size" -> sb.appendLine(queue.size)
            "pop" -> sb.appendLine(if(queue.isEmpty()) -1 else queue.poll())
            "empty" -> sb.appendLine(if(queue.isEmpty()) 1 else 0)
            "front" -> sb.appendLine(if(queue.isEmpty()) -1 else queue.first())
            "back" -> sb.appendLine(if(queue.isEmpty()) -1 else queue.last())
        }
    }

    print(sb)
}