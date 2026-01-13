import java.io.StreamTokenizer
import kotlin.math.max

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val d = i(); val k = i(); val c = i()
    val sushiArr = IntArray(n) { i() }
    val count = IntArray(d+1)
    var uniqueCount = 0
    var max = 0

    repeat(k){
        val s = sushiArr[it % n]
        if(count[s] == 0) uniqueCount++
        count[s]++
    }

    max = if(count[c] == 0){ uniqueCount+1 } else uniqueCount

    for(i in 0 until n-1){
        val remove = sushiArr[i % n]
        val add = sushiArr[(i+k) % n]

        count[remove]--
        if(count[remove] == 0) uniqueCount--

        if(count[add] == 0) uniqueCount++
        count[add]++

        val total = if(count[c] == 0) uniqueCount+1 else uniqueCount
        max = max(max, total)
    }
    print(max)
}