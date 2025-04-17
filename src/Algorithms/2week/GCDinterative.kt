package Algorithms.`2week`

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    fun gcdRecursive(a : Int, b : Int) : Int {
        if(b == 0){
            return a
        }
        return gcdRecursive(b, a % b)
    }

    val n = nextInt(); val m = nextInt()

    val gcd = gcdRecursive(n, m)
    val lcm = n * m / gcd

    println(gcd)
    println(lcm)
}