package BOJ.stack

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    while(true) {
        val input = br.readLine()
        val stack = Stack<Char>()
        if (input == ".") {
            break
        }

        var flag = true
        val replaceInput = input.replace(Regex("[^()\\[\\]]"), "")
        for(x in replaceInput){
            when(x) {
                '(', '[' -> stack.add(x)
                ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        flag = false
                        break
                    }
                }

                ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        flag = false
                        break
                    }
                }
            }
        }

        if(stack.isNotEmpty()) flag = false
        sb.appendLine(if (flag)"yes" else "no")
    }
    print(sb)
}