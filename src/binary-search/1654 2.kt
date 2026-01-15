package BOJ.BinarySearch

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextLong() : Long { nextToken(); return nval.toLong()}

    val k = nextLong(); val n = nextLong()
    val cable = LongArray(k.toInt()) { nextLong() }.sortedArray()

    var start = 0L
    var end = cable.maxOrNull()!! + 1
    while (start + 1 < end) {
        var lan = 0L
        val length = (start + end) / 2
        for (c in cable) {
            lan += c / length
        }

        if (lan >= n) start = length
        else end = length
    }
    print(start)
}