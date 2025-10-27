import java.io.StreamTokenizer
import kotlin.math.sqrt

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val t = i()
    repeat(t){
        val x = i(); val y = i()
        val d = (y - x).toDouble()
        val k = sqrt(d).toLong()
        if (d == k.toDouble() * k.toDouble()) {
            println(2 * k - 1)
        } else if (d <= k * k + k) {
            println(2 * k)
        } else {
            println(2 * k + 1)
        }
    }
}