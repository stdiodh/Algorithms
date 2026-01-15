package BOJ.twoPointer

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    var start = 1; var end = 1
    var sum = 1
    //자기자신 포함
    var cnt = 1

    while(end != n){
        if(sum == n){
            cnt++
            end++
            sum += end
        }
        if(sum > n){
            sum -= start
            start++
        }
        if(sum < n){
            end++
            sum += end
        }
    }
    print(cnt)
}