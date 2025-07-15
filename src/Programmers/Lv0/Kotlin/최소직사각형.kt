package Programmers.Lv0.Kotlin

import kotlin.math.*

class 최소직사각형 {
    fun solution(sizes: Array<IntArray>): Int {
        var maxWidth = 0
        var maxHeight = 0

        for(i in sizes){
            val (w, h) = i
            val longSide = max(w, h)
            val shortSide = min(w, h)
            maxWidth = max(maxWidth, longSide)
            maxHeight = max(maxHeight, shortSide)
        }
        return maxWidth * maxHeight
    }
}

fun main(){
    val n = 최소직사각형()
    println(n.solution(arrayOf(intArrayOf(60,50), intArrayOf(30,70), intArrayOf(60, 30), intArrayOf(80,40))))
}