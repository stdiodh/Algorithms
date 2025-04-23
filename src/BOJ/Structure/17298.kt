package BOJ.Structure

//import java.io.StreamTokenizer
//
//fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
//    fun nextInt() : Int { nextToken(); return nval.toInt() }
//
//    val n = nextInt()
//    val stack = mutableListOf<Int>()
//    val sb = StringBuilder()
//
//    repeat(n){
//        stack.add(nextInt())
//    }
//
//    while(stack.isNotEmpty()) {
//        val num = stack.first()
//        var numIndex = -1
//        for (i in stack.indices) {
//            //오른쪽이 큰 수
//            if (num < stack[i]) {
//                numIndex = i
//                break
//            }
//        }
//        if (numIndex == -1) {
//            sb.append("-1 ")
//        } else {
//            sb.append("${stack[numIndex]} ")
//        }
//        stack.removeFirst()
//    }
//    println(sb)
//}

import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val num = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val stack = Stack<Int>()
    val sb = StringBuilder()

    for(i in 0 until n){
        //스택이 비지않고 오큰수를 찾았을 때 pop하여 스택[인덱스]를 오큰수로 변경
        while (stack.isNotEmpty() && num[stack.peek()] < num[i]){
            num[stack.pop()] = num[i]
        }
        //인덱스 값 push
        stack.push(i)
    }

    //스택에 남아있는 인덱스는 오큰수를 찾지 못한 것
    while(stack.isNotEmpty()){
        num[stack.pop()] = -1
    }

    for(i in 0 until num.size){
        sb.append("${num[i]} ")
    }
    print(sb)
}