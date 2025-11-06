import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val a = i(); val b = i()
    val arr = mutableListOf<Int>()

    repeat(a) {
        val num = i()
        arr.add(num)
    }

    repeat(b) {
        val num = i()
        arr.add(num)
    }

    arr.sort()
    print(arr.joinToString(" "))
}