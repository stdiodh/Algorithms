package BOJ.BinarySearch

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt(): Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val arr = IntArray(n) { nextInt() }
    val price = nextInt()

    var start = 0
    var end = arr.max()
    var answer = 0

    if (arr.sum() <= price) {
        println(arr.max())
    } else {
        while (start <= end) {
            val mid = (start + end) / 2
            val total = arr.sumOf { if (it > mid) mid else it }

            if (total <= price) {
                answer = mid
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        println(answer)
    }
}
