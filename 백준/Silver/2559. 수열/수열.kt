import java.io.StreamTokenizer
import kotlin.math.max

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val k = i()
    val pSum = IntArray(n+1) { 0 }

    repeat(n){
        pSum[it+1] = pSum[it] + i()
    }

    var ans = pSum[k]
    for(i in k until n+1){
        val sum = pSum[i] - pSum[i-k]
        ans = max(ans, sum)
    }
    print(ans)
}