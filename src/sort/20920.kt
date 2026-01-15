package BOJ.sort

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }
    fun string() : String { nextToken(); return sval }

    //n개 단어 m 단어 길이
    val n = int(); val m = int()
    val arr = mutableMapOf<String, Int>()

    repeat(n){
        val str = string()
        if(str.length >= m){
            arr[str] = arr.getOrDefault(str, 0) + 1
        }
    }
    val sortedMap = arr.toList().sortedBy { it.first }.
    sortedByDescending { it.first.length }.sortedByDescending { it.second }

    val sb = StringBuilder()
    for(x in sortedMap.indices){
        sb.appendLine(sortedMap[x].first)
    }
    print(sb)
}