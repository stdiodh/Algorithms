import java.io.StreamTokenizer
import java.util.*

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }
    val n = nextInt()

    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    val sb = StringBuilder()

    repeat(n) {
        val num = nextInt()
        if (num == 0) {
            if (pq.isEmpty()) {
                sb.appendLine(0)
            } else {
                sb.appendLine(pq.poll())
            }
        } else {
            pq.offer(num)
        }
    }
    print(sb)
}