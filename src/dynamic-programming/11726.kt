package BOJ.DP

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val dp = IntArray(n+1) { 0 }

    dp[1] = 1
    dp[2] = 2

    for(i in 3 .. n){
        dp[i] = dp[i-1] + dp[i-2]
    }
    print(dp[n] % 10007)
}