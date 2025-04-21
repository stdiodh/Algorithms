package BOJ.Structure

import java.io.StreamTokenizer
import java.util.Stack

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val stack = Stack<Int>()
    val arr = IntArray(n) { nextInt() }
    val sb = StringBuilder()
    var cnt = 1

    for(i in arr){
        while(cnt <= i){
            //추가해야 하는 수가 수열의 현재 수 이하이면 계속 스택 추가
            stack.push(cnt++)
            sb.appendLine("+")
        }

        //스택의 탑이 현재수와 같으면 추출하고 sb에 - 추가
        if(stack.peek() == i){
            stack.pop()
            sb.appendLine("-")
        } else {
            //스택의 가장 위 값이 수열의 현재와 다르면 종료
            println("NO")
            return@with
        }
    }
    print(sb)
}