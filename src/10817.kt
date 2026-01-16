import java.io.StreamTokenizer
import kotlin.math.max

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt() : Int { nextToken(); return nval.toInt() }

    val a = readInt(); val b = readInt(); val c = readInt()
    val abMax = max(a, b)
    val acMax = max(a, c)
    val bcMax = max(b, c)
    val min = minOf(abMax, acMax, bcMax)

    print(min)
}
