package Programmers.Kotlin

import java.io.StreamTokenizer

class `세로읽기` {
    fun solution(my_string: String, m: Int, c: Int): String {
        return my_string.chunked(m).map { it[c - 1] }.joinToString("")
    }
}

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun s() : String { nextToken(); return sval }

    val i = 세로읽기()
    val str = s()
    println(i.solution(str, 4, 2))
}