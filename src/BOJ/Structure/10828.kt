package BOJ.Structure

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun next() : String { nextToken(); return sval }
    fun nextInt() : Int { nextToken(); return nval.toInt() }
    val n = nextInt()
    val sb = StringBuilder()
    val stack = mutableListOf<Int>()

    repeat(n){
        val command = next()

        when(command) {
            "push" -> {
                val num = nextInt()
                stack.add(num)
            }
            "top" -> sb.appendLine(if (stack.isEmpty()) -1 else stack.last())
            "empty" -> sb.appendLine(if (stack.isEmpty()) 1 else 0)
            "size" -> sb.appendLine(stack.size)
            "pop" -> if (stack.isEmpty()) {
                sb.appendLine(-1)
            } else {
                sb.appendLine(stack.last())
                stack.removeLast()
            }
        }
    }
    print(sb)
}
