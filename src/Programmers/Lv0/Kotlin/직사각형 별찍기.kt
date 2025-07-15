package Programmers.Lv0.Kotlin

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt() : Int { nextToken(); return nval.toInt() }
    val a = nextInt(); val b = nextInt()

    val sb = StringBuilder()
    repeat(b){
        repeat(a){
            sb.append("*")
        }
        sb.appendLine()
    }
    print(sb)
}