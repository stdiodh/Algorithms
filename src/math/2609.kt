import kotlin.math.max
import kotlin.math.min

private fun gcd(a: Int, b: Int): Int {
    var x = max(a, b)
    var y = min(a, b)

    while (y != 0) {
        val r = x % y
        x = y
        y = r
    }

    return x
}

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val g = gcd(a, b)
    val l = a / g * b

    println(g)
    println(l)
}
