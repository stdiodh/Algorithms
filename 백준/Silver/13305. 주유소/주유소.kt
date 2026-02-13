import java.io.StreamTokenizer
import kotlin.math.min

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextLong() : Long { nextToken(); return nval.toLong() }

    val n = nextLong().toInt() - 1
    val km = LongArray(n) { nextLong() }
    val gas = LongArray(n) { nextLong() }

    var minPrice = gas[0]
    var money = 0L

    for(x in 0 ..< n){
        minPrice = min(minPrice,  gas[x])
        money += minPrice * km[x]
    }
    print(money)
}