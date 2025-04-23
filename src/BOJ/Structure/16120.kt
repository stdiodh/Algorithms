package BOJ.Structure

import java.io.StreamTokenizer
import java.util.*

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun next() : String { nextToken(); return sval }

    val str = next()
    val stack = Stack<Char>()

    for(i in str){
        stack.add(i)

        if(stack.size >= 4 &&
            stack[stack.size - 4] == 'P' &&
            stack[stack.size - 3] == 'P' &&
            stack[stack.size - 2] == 'A' &&
            stack[stack.size - 1] == 'P') {
            repeat(4) { stack.removeAt(stack.lastIndex) }
            stack.add('P')
        }
    }
    print(if(stack.size==1 && stack[0] == 'P') "PPAP" else "NP")
}