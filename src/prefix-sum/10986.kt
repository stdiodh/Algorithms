package BOJ.pSum

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val m = i()

    val sumArr = LongArray(n + 1) { 0 }
    for (i in 1 .. n) {
        sumArr[i] = sumArr[i - 1] + i()
    }

    val remainderArr = LongArray(m) { 0 }
    var count = 0L
    for (i in 1 .. n) {
        val rem = sumArr[i].rem(m).toInt()
        remainderArr[rem]++
    }
    count += remainderArr[0]

    for (i in 0 ..< m) {
        count += (remainderArr[i] * (remainderArr[i] - 1)) / 2
    }
    print(count)
}