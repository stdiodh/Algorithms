package BOJ.DivMul

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt()}

    val n = nextInt()

    var i = 1
    var cnt = 0

    while(i * i <= n){
        cnt+=1
        i++
    }

    println(cnt)
}