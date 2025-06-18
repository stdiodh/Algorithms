package BOJ.Math

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }

    val n = int()

    fun pack(n : Long) : Long{
        if(n == 0L){
            return 1
        }

        return if(n > 1){
            n * pack(n-1)
        } else {
            n
        }
    }
    println(pack(n.toLong()))
}