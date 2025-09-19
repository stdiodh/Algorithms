import java.io.StreamTokenizer
import kotlin.math.pow

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i(): Int { nextToken(); return nval.toInt() }

    val n = i()

    val totalMoves = 2.0.pow(n)- 1
    val sb = StringBuilder()

    fun hanoi(n: Int, start: Int, end: Int, aux: Int){
        if(n == 1){
            sb.appendLine("$start $end")
            return
        }

        hanoi(n-1, start, aux, end)
        sb.appendLine("$start $end")
        hanoi(n-1, aux, end, start)
    }

    println(totalMoves.toInt())
    hanoi(n, 1, 3, 2)
    print(sb)
}