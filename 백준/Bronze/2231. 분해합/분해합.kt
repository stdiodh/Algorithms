import java.io.StreamTokenizer
import kotlin.math.min

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    var min = Int.MAX_VALUE
    val start = maxOf(1, n - 9 * n.toString().length)
    for(i in start .. n) {
        var num = i
        var sum = 0
        while(true){
            if(num <= 0){
                break
            }
            sum += num % 10
            num /= 10
        }
        if(i + sum == n) {
            min = min(min, i)
        }
    }

    if(min == Int.MAX_VALUE) {
        print(0)
    } else {
        print(min)
    }
}