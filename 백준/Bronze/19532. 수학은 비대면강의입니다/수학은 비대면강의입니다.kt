import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val a1 = i(); val b1 = i(); val c1 = i(); val a2 = i(); val b2 = i(); val c2 = i()

    for(x in -999 .. 999) {
        for(y in -999 .. 999) {
            if((a1 * x + b1 * y) == c1 && (a2 * x + b2 * y) == c2) {
                print("$x $y")
                break
            }
        }
    }
}