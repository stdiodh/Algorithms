package BOJ.DivMul

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val a1 = nextInt(); val a2 = nextInt()
    val b1 = nextInt(); val b2 = nextInt()

    fun gcd(a: Int, b: Int) : Int {
        return if(b == 0){
            a
        } else {
            gcd(b, a % b)
        }
    }

    fun lcm(a: Int, b: Int) : Int {
        return a * b / gcd(a, b)
    }

    val bottom = lcm(a2, b2)
    val top = (bottom/a2) * a1 + (bottom/b2) * b1

    val resultGcd = gcd(top, bottom)
    val resultTop = top / resultGcd
    val resultBottom = bottom / resultGcd

    println("$resultTop $resultBottom")
}