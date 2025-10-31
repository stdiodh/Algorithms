import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val a1 = i(); val b1 = i(); val c1 = i(); val a2 = i(); val b2 = i(); val c2 = i()

    val x = (c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1)
    val y = (a1 * c2 - a2 * c1) / (a1 * b2 - a2 * b1)

    println("$x $y")
}