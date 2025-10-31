import java.io.StreamTokenizer
import kotlin.math.min

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    var min = Int.MAX_VALUE
    for(i in 1 .. n) {
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