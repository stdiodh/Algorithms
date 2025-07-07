package BOJ.pSum

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val m = i();
    val sb = StringBuilder()

    val pSum = IntArray(n+1) { 0 }
    for(i in 0 until n){
        pSum[i+1] = pSum[i] + i()
    }

    repeat(m){
        val a = i(); val b = i()
        sb.appendLine(pSum[b] - pSum[a-1])
    }

    print(sb)
}