import java.io.StreamTokenizer
import kotlin.math.min

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val s = i()
    val sumArr = IntArray(n+1) { 0 }
    repeat(n) {
        sumArr[it+1] = sumArr[it] + i()
    }
    var start = 0; var end = 1
    var length = Int.MAX_VALUE
    while(end <= n) {
        val sum = sumArr[end] - sumArr[start]
        if(sum >= s) {
            length = min(length, end - start)
            start++
        } else {
            end++
        }
    }

    if(length == Int.MAX_VALUE) {
        print(0)
    } else {
        print(length)
    }
}