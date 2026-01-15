package BOJ.stack

import java.io.StreamTokenizer
import java.util.*

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val arr = IntArray(n) { i() }
    val stack = Stack<Int>()
    val sb = StringBuilder()

    var num = 1
    var flag = true
    for(i in 0 until n){
        val su = arr[i]
        if(su >= num){
            while(su >= num){
                stack.push(num++)
                sb.appendLine("+")
            }
            stack.pop()
            sb.appendLine("-")
        } else {
            val j = stack.pop()
            if(j > su){
                flag = false
                break
            } else {
                sb.appendLine("-")
            }
        }

    }
    if(!flag){
        print("NO")
    } else {
        print(sb)
    }

}