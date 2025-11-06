import java.io.StreamTokenizer
import kotlin.math.max

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val k = i() * 2 + 1
    val arr = IntArray(1000001) { 0 }

    repeat (n) {
        //g = 얼음 양, x = 양동이 좌표
        val g = i(); val x = i()
        arr[x] = g
    }

    var sum = 0
    var maxIce = 0
    for (i in 0 ..< 1000001) {
        if (i - k >= 0) sum -= arr[i - k]
        sum += arr[i]
        maxIce = max(maxIce, sum)
    }

    print(maxIce)
}