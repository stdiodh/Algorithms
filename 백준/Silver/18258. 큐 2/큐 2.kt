import java.io.StreamTokenizer
import kotlin.collections.ArrayDeque

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }
    fun string() : String { nextToken(); return sval }

    val n = int()
    val queue = ArrayDeque<Int>()
    val sb = StringBuilder()

    repeat(n){
        val cmd = string()

        when(cmd){
            "push" -> {
                val num = int()
                queue.add(num)
            }
            "pop" -> {
                if(queue.isNotEmpty()){
                    val pop = queue.first()
                    sb.appendLine(pop)
                    queue.removeFirst()
                } else {
                    sb.appendLine(-1)
                }
            }
            "size" -> {
                sb.appendLine(queue.size)
            }
            "empty" -> {
                sb.appendLine(if(queue.isNotEmpty()) 0 else 1)
            }
            "front" -> {
                if(queue.isNotEmpty()){
                    val num = queue.first()
                    sb.appendLine(num)
                } else {
                    sb.appendLine(-1)
                }
            }
            "back" -> {
                if(queue.isNotEmpty()){
                    val num = queue.last()
                    sb.appendLine(num)
                } else {
                    sb.appendLine(-1)
                }
            }
        }
    }
    println(sb)
}