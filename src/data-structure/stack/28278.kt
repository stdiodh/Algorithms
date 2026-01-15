package BOJ.stack

import java.io.StreamTokenizer
import java.util.*

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val stack = Stack<Int>()
    val sb = StringBuilder()
    repeat(n){
        val cmd = nextInt()
        when(cmd){
            1 -> {
                val num = nextInt()
                stack.push(num)
            }
            2 -> {
                if(stack.isNotEmpty()) {
                    sb.appendLine(stack.pop())
                } else{
                    sb.appendLine(-1)
                }
            }
            3 -> {
                sb.appendLine(stack.size)
            }
            4 -> {
                if(stack.isNotEmpty()){
                    sb.appendLine(0)
                } else {
                    sb.appendLine(1)
                }
            }
            5 -> {
                if(stack.isNotEmpty()) {
                    sb.appendLine(stack.peek())
                } else {
                    sb.appendLine(-1)
                }
            }
        }
    }
    print(sb)
}