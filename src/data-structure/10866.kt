package BOJ.Structure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main()  = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()

    repeat(n){
        val tokenizer = StringTokenizer(readLine(), " ")
        when(tokenizer.nextToken()){
            "push_front" -> {
                deque.addFirst(tokenizer.nextToken().toInt())
            }
            "push_back" -> {
                deque.addLast(tokenizer.nextToken().toInt())
            }
            "pop_front" -> {
                sb.appendLine(if(deque.isEmpty()) -1 else {
                    deque.first()
                    deque.removeFirst()
                })
            }
            "pop_back" -> {
                sb.appendLine(if(deque.isEmpty()) -1 else {
                    deque.last()
                    deque.removeLast()
                })
            }
            "size" -> {
                sb.appendLine(deque.size)
            }
            "empty" -> {
                sb.appendLine(if(deque.isEmpty()) 1 else 0)
            }
            "front" -> {
                sb.appendLine(if(deque.isEmpty()) -1 else deque.first())
            }
            "back" -> {
                sb.appendLine(if(deque.isEmpty()) -1 else deque.last())
            }
            else -> {

            }
        }
    }
    print(sb)
}