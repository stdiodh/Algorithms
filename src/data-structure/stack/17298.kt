package BOJ.stack

import java.io.StreamTokenizer
import java.util.Stack

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val nArr = IntArray(n) { i() }
    val stack = Stack<Int>()
    val sb = StringBuilder()

    //배열의 인덱스를 돌리는 반복문
    for(i in 0 until n){
        //스택이 비지 않고 왼쪽 부분을 확인해서 만약 nArr의 인덱스보다 수가 크면
        while(stack.isNotEmpty() && nArr[stack.peek()] < nArr[i]){
            //그 수의 자리에 오큰수를 넣음
            nArr[stack.pop()] = nArr[i]
        }
        //스택에 다음 인덱스를 추가함
        stack.push(i)
    }

    //스택이 비지 않을때 까지 남는 수를 -1을 넣음
    while (stack.isNotEmpty()){
        nArr[stack.pop()] = -1
    }

    for(i in 0 until n){
        sb.append("${nArr[i]} ")
    }
    print(sb)
}