package Programmers.Lv1

import kotlin.math.pow

class `진법뒤집기` {
    fun solution(n: Int): Int {
        val trd = mutableListOf<Int>()
        var cnt = n
        var result = 0
        while(cnt > 0){
            trd.add(cnt % 3)
            cnt /= 3
        }

        trd.reverse()
        for(i in trd.indices){
            result += trd[i] * 3.0.pow(i).toInt()
        }

        return result
    }
}

fun main(){
    val n = 진법뒤집기()
    println(n.solution(45))
}