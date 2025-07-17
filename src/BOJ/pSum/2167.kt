package BOJ.pSum

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt()}

    val n = i(); val m = i()
    val pSum = Array(n+1) { IntArray(m+1) { 0 } }
    val sb = StringBuilder()
    repeat(n){ idx ->
        repeat(m){ jdx ->
            pSum[idx+1][jdx+1] = pSum[idx+1][jdx] + pSum[idx][jdx+1] - pSum[idx][jdx] + i()
        }
    }

    val k = i()
    repeat(k){
        val x1 = i(); val y1 = i(); val x2 = i(); val y2 = i()
        sb.appendLine(pSum[x2][y2] - pSum[x1 - 1][y2] - pSum[x2][y1 - 1] + pSum[x1 - 1][y1 - 1])
    }
    print(sb)
}