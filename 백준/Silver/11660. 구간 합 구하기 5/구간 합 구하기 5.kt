package pSum

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt() : Int {
        nextToken()
        return nval.toInt()
    }

    //n * m의 크기의 배열을 받음
    val n = nextInt(); val m = nextInt()
    val pSum = Array(n+1){
        IntArray(n+1) { 0 }
    }

    repeat(n){idx ->
        repeat(n){jdx ->
            pSum[idx+1][jdx+1] = pSum[idx][jdx+1] + pSum[idx+1][jdx] - pSum[idx][jdx] + nextInt()
        }
    }

    val sb = StringBuilder()
    repeat(m){
        val x1 = nextInt(); val y1 = nextInt(); val x2 = nextInt(); val y2 = nextInt()
        sb.appendLine(pSum[x2][y2] - pSum[x2][y1-1] - pSum[x1-1][y2] + pSum[x1-1][y1-1])
    }
    println(sb)
}