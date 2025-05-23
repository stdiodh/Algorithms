package BOJ.parsing

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }
    fun next() : String { nextToken(); return sval }
    val map = mutableMapOf<String, Int>()

    repeat(nextInt()){
        val sb = next().split(".")
        map[sb[1]] = map.getOrDefault(sb[1], 0) + 1
    }

    val sorted = map.entries.sortedBy { it.key }
    for(x in sorted.indices){
        println("${sorted[x].key} ${sorted[x].value}")
    }
}