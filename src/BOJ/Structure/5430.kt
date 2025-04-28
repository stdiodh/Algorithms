package BOJ.Structure

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val command = br.readLine()
        val numSize = br.readLine().toInt()
        val input = br.readLine()
        val deque = ArrayDeque<Int>()

        if (numSize > 0) {
            val elements = input.removePrefix("[").removeSuffix("]").split(",")
            elements.forEach { deque.add(it.toInt()) }
        }

        var isReversed = false
        var isError = false

        for (c in command) {
            when (c) {
                'R' -> isReversed = !isReversed
                'D' -> {
                    if (deque.isEmpty()) {
                        isError = true
                        break
                    }
                    if (isReversed) deque.removeLast()
                    else deque.removeFirst()
                }
            }
        }

        if (isError) {
            sb.appendLine("error")
        } else {
            val result = if (isReversed) deque.reversed() else deque
            sb.appendLine(result.joinToString(",",prefix = "[", postfix = "]"))
        }
    }

    print(sb)
}
