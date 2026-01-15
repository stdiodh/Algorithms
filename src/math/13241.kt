package BOJ.DivMul

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextLong() : Long { nextToken(); return nval.toLong() }

    fun gcd(a : Long, b : Long) : Long {
        return if(b == 0L){
            a
        } else {
            gcd(b, a % b)
        }
    }

    val a = nextLong(); val b = nextLong()
    println(a * b / gcd(a, b))
}