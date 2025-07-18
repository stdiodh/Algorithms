package BOJ.pSum

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val arr = IntArray(n) { i() }
    val pSum = LongArray(n+1) { 0 }
    var result = 0L

    repeat(n){
        pSum[it+1] = pSum[it] + arr[it]
    }

    repeat(n){
        result += arr[it] * (pSum[n] - pSum[it + 1])
    }
    print(result)
}