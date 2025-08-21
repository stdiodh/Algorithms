package BOJ.DP

import java.io.StreamTokenizer
import kotlin.math.max

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    //n = 물품의 수 k = 버틸 수 있는 무게
    val n = nextInt(); val k = nextInt()
    val knap = Array(n+1) { IntArray(k+1) { 0 } }
    //first = 무게 second = 가치
    val thing = Array(n) { Pair(nextInt(), nextInt()) }

    for (i in 1..n) {
        for (j in 1 .. k) {
            val weight = thing[i - 1].first
            val value = thing[i - 1].second
            if (j >= weight) {
                knap[i][j] = max(knap[i - 1][j], knap[i - 1][j - weight] + value)
            } else {
                knap[i][j] = knap[i - 1][j]
            }
        }
    }
    print(knap[n][k])
}

//1차원 배열 개선 + 모법 답안

//fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
//    fun nextInt() : Int { nextToken(); return nval.toInt() }
//    val n = nextInt(); val k = nextInt()
//    val dp = IntArray(k + 1)
//    for (i in 0 until n) {
//        val w = nextInt(); val v = nextInt()
//        for (j in k downTo w) {
//            dp[j] = maxOf(dp[j], dp[j - w] + v)
//        }
//    }
//    println(dp[k])
//}