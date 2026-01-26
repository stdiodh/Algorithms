import java.io.StreamTokenizer
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }

    val n = int()
    val queue = LinkedList<Int>()

    repeat(n){
        queue.add(it+1)
    }

    while(queue.size > 1){
        queue.poll()
        val next = queue.poll()
        queue.add(next)
    }
    println(queue.poll())
}