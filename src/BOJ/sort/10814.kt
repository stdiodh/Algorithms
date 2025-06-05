package BOJ.sort

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun next() : String { nextToken(); return sval }
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val map = Array<Pair<Int, String>>(n){ Pair(nextInt(), next()) }
    val mapSort = map.sortedBy { it.first }

    mapSort.forEach{ println("${it.first} ${it.second}") }
}