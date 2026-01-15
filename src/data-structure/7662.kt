import java.io.StreamTokenizer
import java.util.*

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun next(): String { nextToken(); return sval }
    fun nextInt(): Int { nextToken(); return nval.toInt() }

    val t = nextInt()
    repeat(t) {
        val n = nextInt()
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
        val map = mutableMapOf<Int, Int>()

        fun clean(heap: PriorityQueue<Int>) {
            while (heap.isNotEmpty() && map[heap.peek()] == 0) {
                heap.poll()
            }
        }

        repeat(n) {
            when (next()) {
                "I" -> {
                    val num = nextInt()
                    minHeap.add(num)
                    maxHeap.add(num)
                    map[num] = map.getOrDefault(num, 0) + 1
                }
                "D" -> {
                    val type = nextInt()
                    if (type == 1) {
                        clean(maxHeap)
                        if (maxHeap.isNotEmpty()) {
                            val max = maxHeap.poll()
                            map[max] = map[max]!! - 1
                        }
                    } else {
                        clean(minHeap)
                        if (minHeap.isNotEmpty()) {
                            val min = minHeap.poll()
                            map[min] = map[min]!! - 1
                        }
                    }
                }
            }
        }

        clean(minHeap)
        clean(maxHeap)

        if (map.values.sum() == 0) {
            println("EMPTY")
        } else {
            println("${maxHeap.peek()} ${minHeap.peek()}")
        }
    }
}
