package BOJ.pSum

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }
    val n = i(); val m = i()
    val pSum = Array(n+1) { IntArray(n+1) { 0 } }
    val sb = StringBuilder()

    repeat(n){i ->
        repeat(n){j ->
            pSum[i+1][j+1] = pSum[i][j+1] + pSum[i+1][j] - pSum[i][j] + i()
        }
    }

    repeat(m){
        val x1 = i(); val y1 = i(); val x2 = i(); val y2 = i()

        sb.appendLine(pSum[x2][y2] - pSum[x1 - 1][y2] - pSum[x2][y1 - 1] + pSum[x1 - 1][y1 - 1])
    }
    print(sb)
}