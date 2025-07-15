package Programmers.Lv0.Kotlin

import java.io.StreamTokenizer

class `특별한이차원배열2` {
    fun solution(arr: Array<IntArray>): Int {
        for(i in 0 until arr.size) {
            for(j in 0 until arr[i].size) {
                if(arr[i][j] != arr[j][i]) return 0
            }
        }
        return 1
    }
}

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }
    val s = 특별한이차원배열2()
    val arr = Array(3) { IntArray(3) { i() } }
    println(s.solution(arr))
}