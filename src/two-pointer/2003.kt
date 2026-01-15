package BOJ.twoPointer

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i () : Int { nextToken(); return nval.toInt() }

    val n = i(); val m = i()
    val pSum = IntArray(n+1) { 0 }
    repeat(n){
        pSum[it+1] = pSum[it] + i()
    }

    var cnt = 0
    var start = 0; var end = 0

    while(start <= end && end <= n){
        val result = pSum[end] - pSum[start]
        if(result == m){
            cnt++
            start++
        } else if (result < m){
            end++
        } else {
            start++
        }
    }
    print(cnt)
}