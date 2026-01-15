package BOJ.Structure

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val stack = mutableListOf<Int>()
    repeat(n){
        val input = nextInt()

        if(input == 0){
            stack.removeLast()
        } else {
            stack.add(input)
        }
    }

    print(stack.sum())
}