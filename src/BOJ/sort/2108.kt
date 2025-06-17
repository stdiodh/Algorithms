package BOJ.sort

import java.io.StreamTokenizer
import kotlin.math.round

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val arr = IntArray(n) { nextInt() }.sortedArray()
    val sb = StringBuilder()

    val total = arr.reduce { total, num -> total + num }
    sb.appendLine(round(total.toDouble() / n).toInt())

    val mid = (n / 2)
    sb.appendLine(arr[mid])

    val mostArr = arr.groupBy { it }.mapValues { it.value.count() }
    val maxFreq = mostArr.maxOf { it.value }
    val modes = mostArr.filterValues { it == maxFreq }.keys.sorted()
    val three = if (modes.size >= 2) modes[1] else modes[0]
    sb.appendLine(three)

    val four = arr[n-1] - arr[0]
    sb.appendLine(four)
    print(sb)
}