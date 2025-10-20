import java.io.StreamTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val maxPrev = IntArray(3)
    val minPrev = IntArray(3)
    val maxCurr = IntArray(3)
    val minCurr = IntArray(3)

    repeat(3) { j ->
        val num = i()
        maxPrev[j] = num
        minPrev[j] = num
    }

    for (i in 1 ..< n) {
        val c0 = i()
        val c1 = i()
        val c2 = i()

        maxCurr[0] = c0 + max(maxPrev[0], maxPrev[1])
        maxCurr[1] = c1 + maxOf(maxPrev[0], maxPrev[1], maxPrev[2])
        maxCurr[2] = c2 + max(maxPrev[1], maxPrev[2])

        minCurr[0] = c0 + min(minPrev[0], minPrev[1])
        minCurr[1] = c1 + minOf(minPrev[0], minPrev[1], minPrev[2])
        minCurr[2] = c2 + min(minPrev[1], minPrev[2])

        maxPrev[0] = maxCurr[0]
        maxPrev[1] = maxCurr[1]
        maxPrev[2] = maxCurr[2]

        minPrev[0] = minCurr[0]
        minPrev[1] = minCurr[1]
        minPrev[2] = minCurr[2]
    }

    val maxResult = maxPrev.maxOrNull() ?: 0
    val minResult = minPrev.minOrNull() ?: 0

    print("$maxResult $minResult")
}