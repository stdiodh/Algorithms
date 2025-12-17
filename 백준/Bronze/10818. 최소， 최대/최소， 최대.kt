import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val arr = IntArray(n) { nextInt() }

    val min = arr.minOf { it }
    val max = arr.maxOf { it }
    print("$min $max")
}