package BOJ.queue

import java.io.StreamTokenizer
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }

    val n = int(); val k = int()

    val queue = LinkedList<Int>()
    val sb = StringBuilder()

    repeat(n){
        queue.add(it+1)
    }

    var cnt = 1
    sb.append("<")

    while(queue.size > 1){
        val num = queue.pop()
        if(cnt == k){
            sb.append("$num, ")
            cnt = 1
        } else {
            queue.add(num)
            cnt++
        }
    }
    sb.append("${queue.poll()}>")

    println(sb)
}