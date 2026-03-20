import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt(): Int {
        nextToken(); return nval.toInt()
    }

    fun readString(): String {
        nextToken(); return sval
    }

    val n = readInt(); val k = readInt()
    val intArr = IntArray(n) { readInt() }.sorted()

    println(intArr[n - k])
}