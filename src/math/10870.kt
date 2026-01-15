package BOJ.Math

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }

    val n = int()

    fun fibo(n : Int) : Int {
        if(n <= 1){
            return n
        } else {
            return fibo(n - 1) + fibo(n - 2)
        }
    }

    println(fibo(n))
}