package BOJ.Structure

import java.io.StreamTokenizer
import java.util.*

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt(): Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val heights = IntArray(n) { nextInt() }
    val answer = IntArray(n)
    val stack = Stack<Pair<Int, Int>>()

    for (i in 0 until n) {
        val currHeight = heights[i]

        while (stack.isNotEmpty() && stack.peek().second < currHeight) {
            stack.pop()
        }

        answer[i] = if (stack.isEmpty()) 0 else stack.peek().first + 1
        stack.push(Pair(i, currHeight))
    }

    println(answer.joinToString(" "))
}
