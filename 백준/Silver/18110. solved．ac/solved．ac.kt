import java.io.StreamTokenizer
import kotlin.math.roundToInt

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt(): Int {
        nextToken(); return nval.toInt()
    }

    fun readString(): String {
        nextToken(); return sval
    }

    val n = readInt()
    
    if (n == 0) {
        print(0)
        return
    }

    val scoreArr = IntArray(n) { readInt() }.sortedArray()
    val cut = (n * 0.15).roundToInt()

    repeat(cut) { it ->
        scoreArr[it] = 0
        scoreArr[scoreArr.lastIndex - it] = 0
    }

    val sum = scoreArr.sum()
    val count = n - cut * 2

    print((sum.toDouble() / count).roundToInt())
}
