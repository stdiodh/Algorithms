import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt(): Int {
        nextToken(); return nval.toInt()
    }

    fun readString(): String {
        nextToken(); return sval
    }

    val n = readInt()
    val intArr = IntArray(n) { readInt() }.sortedArray()

    intArr.forEach { println(it) }
}