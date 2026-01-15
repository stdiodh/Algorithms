package BOJ.pSum

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val m = i()
    val pSum = IntArray(n+1) { 0 }
    val sb = StringBuilder()
    repeat(n){
        pSum[it+1] = pSum[it] + i()
    }

    repeat(m){
        val q1 = i(); val q2 = i()
        sb.appendLine(pSum[q2] - pSum[q1-1])
    }
    print(sb)
}