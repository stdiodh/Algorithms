package BOJ.twoPointer

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val m = i()
    val arr = IntArray(n) { i() }.sortedArray()

    var start = 0; var end = n-1
    var cnt = 0

    while(start < end){
        val sum = arr[start] + arr[end]
        if(sum == m){
            cnt++
            start++
            end--
        } else if(sum < m){
            start++
        } else {
            end--
        }
    }
    print(cnt)
}