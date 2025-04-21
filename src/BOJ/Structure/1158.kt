package BOJ.Structure

import java.io.StreamTokenizer
import java.util.LinkedList
import java.util.Queue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt(); val k = nextInt()
    val queue : Queue<Int> = LinkedList()
    val sb = StringBuilder()

    var cnt = 1
    repeat(n){
        queue.add(it + 1)
    }

    sb.append("<")

    while(queue.size > 1){
        //첫 값 삭제
        val num = queue.poll()
        if(cnt == k){
            sb.append("${num}, ")
            cnt = 1
        } else {
            queue.add(num)
            cnt++
        }
    }
    sb.append("${queue.poll()}>")
    print(sb)
}