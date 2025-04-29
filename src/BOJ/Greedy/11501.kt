package BOJ.Greedy

import java.io.StreamTokenizer
import kotlin.math.max

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val t = nextInt()
    val sb = StringBuilder()
    repeat(t){
        val day = nextInt()
        val stockArr = IntArray(day) { nextInt() }

        var max = stockArr[stockArr.size - 1]
        var result = 0L

        for(i in day - 2 downTo  0){
            max = max(max, stockArr[i])
            if(max > stockArr[i]){
                result += max - stockArr[i]
            } else {
                continue
            }
        }
        sb.appendLine(result)
    }
    print(sb)
}