package BOJ.map

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun next() : String { nextToken(); return sval }
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val companyMap = mutableMapOf<String, String>()
    val sb = StringBuilder()

    repeat(n){
        val name = next(); val status = next();
        if (status == "leave"){
            companyMap.remove(name)
        } else {
            companyMap[name] = status
        }
    }
    companyMap.keys.sortedDescending().map { sb.appendLine(it) }
    println(sb)
}