import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val a = i(); val b = i()
    val aArr = IntArray(a) { i() }
    val bArr = IntArray(b) { i() }

    print((aArr + bArr).sortedArray().joinToString(" "))
}