package Programmers.Kotlin

import kotlin.math.abs

class `부족한금액계산하기` {
    fun solution(price: Int, money: Int, count: Int): Long {
        var need: Long = 0
        var minus : Long = 0
        for(i in 1 .. count){
            minus = price.toLong() * i.toLong()
            need += minus
        }
        if(money.toLong() - need >= 0){
            return 0
        } else {
            return abs(money.toLong() - need)
        }
    }
}

fun main(){
    val n = 부족한금액계산하기()
    println(n.solution(2500, 4, 2500))
}