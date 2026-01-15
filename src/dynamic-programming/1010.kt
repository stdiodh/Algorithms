package BOJ.DP

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt(): Int { nextToken(); return nval.toInt() }

    val dp = Array(31){ IntArray(31) }

    for(i in 1 .. 30){
        dp[1][i] = i
    }

    for(x in 2..30){
        for(y in 2..30){

            if(x == y){
                dp[x][y] = 1
            } else {
                dp[x][y] = dp[x-1][y-1] + dp[x][y-1]
            }
        }
    }

    val sb = StringBuilder()
    repeat(nextInt()){
        val n = nextInt(); val m = nextInt()
        sb.appendLine(dp[n][m])
    }
    print(sb)
}