import java.io.StreamTokenizer
import kotlin.math.abs

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt() : Int {
        nextToken()
        return nval.toInt()
    }

    var total = 0
    val arr = IntArray(10) {
        nextInt()
    }

    for (i in 0 ..< 10) {
        if (abs(total + arr[i] - 100) <= abs(total - 100)) {
            total += arr[i]
        } else {
            break
        }
    }
    print(total)
}