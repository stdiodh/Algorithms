package BOJ.sort

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val numArr = Array(n) { nextInt() }

    val numSortedMap = numArr.sorted().distinct().mapIndexed { index: Int, i: Int -> i to index }.toMap()

    val replaceNumArr = numArr.map { numSortedMap[it] ?: 0}

    println(replaceNumArr.joinToString(" "))
}