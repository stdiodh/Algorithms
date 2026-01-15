package BOJ.Structure

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(n){
        val arr = Stack<Char>()
        val s = br.readLine()
        for(j in s){
            if(j == '('){
                arr.push(j)
            } else if (j == ')'){
                if(arr.empty()){
                    arr.push(j)
                    break
                } else {
                    arr.pop()
                }
            }
        }
        if(arr.empty()){
            sb.appendLine("YES")
        } else {
            sb.appendLine("NO")
        }
    }
    print(sb)
}