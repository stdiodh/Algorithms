package Programmers.Lv0.Kotlin

import kotlin.math.*

class `최대공약수와 최대공배수` {
    fun solution(n: Int, m: Int) = intArrayOf(gcd(n, m), lcm(n, m))

    fun gcd(n: Int, m: Int) : Int{
        var min = min(n, m)
        var max = max(n, m)

        while(max != 0){
            val r = min % max
            min = max
            max = r
        }
        return min
    }

    fun lcm(n: Int, m: Int): Int = n * m / gcd(n, m)
}