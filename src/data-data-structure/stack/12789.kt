package BOJ.stack

import java.io.StreamTokenizer
import java.util.*

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val arr = mutableListOf<Int>()
    val stack = Stack<Int>()
    var cnt = 1

    repeat(n){
        val num = nextInt()
        arr.add(num)
    }

    while(arr.isNotEmpty()){
        val num = arr.removeFirst()
        if(cnt == num){
            cnt++
        } else {
            stack.add(num)
        }

        while(stack.isNotEmpty() && stack.peek() == cnt){
            stack.pop()
            cnt++
        }
    }


    if(cnt - 1 == n){
        println("Nice")
    } else {
        println("Sad")
    }
}