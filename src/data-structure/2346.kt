import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val tokens = br.readLine().split(" ").map { it.toInt() }

    val deque = ArrayDeque<Pair<Int, Int>>() // Pair(index, move)
    for (i in 1..n) {
        deque.add(Pair(i, tokens[i - 1]))
    }

    val result = mutableListOf<Int>()

    while (deque.isNotEmpty()) {
        val (idx, move) = deque.removeFirst()
        result.add(idx)

        if (deque.isEmpty()) break

        if (move > 0) {
            repeat(move - 1) {
                deque.addLast(deque.removeFirst())
            }
        } else {
            repeat(-move) {
                deque.addFirst(deque.removeLast())
            }
        }
    }

    println(result.joinToString(" "))
}
