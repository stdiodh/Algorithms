import java.io.StreamTokenizer
import java.util.Comparator
import java.util.PriorityQueue
import kotlin.math.abs

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val overHeap = PriorityQueue<Int>()
    val underHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    val sb = StringBuilder()
    repeat(n){
        val num = nextInt()

        if(num > 0){
            overHeap.add(num)
        } else if(num == 0){
            if(overHeap.isEmpty() && underHeap.isEmpty()){
                sb.appendLine(0)
            } else {
                val over = overHeap.peek() ?: null
                val under = underHeap.peek() ?: null
                if(under != null){
                    if(over != null){
                        if(abs(under) > over){
                            sb.appendLine(overHeap.poll())
                        } else {
                            sb.appendLine(underHeap.poll())
                        }
                    } else {
                        sb.appendLine(underHeap.poll())
                    }
                } else {
                    sb.appendLine(overHeap.poll())
                }
            }
        } else {
            underHeap.add(num)
        }
    }
    print(sb)
}