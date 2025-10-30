import java.io.StreamTokenizer
import kotlin.math.min

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val m = i()
    var min = Int.MAX_VALUE
    var sum = 0

    val arr = IntArray(m + 1) { it }
    
    if (m >= 1){
        arr[0] = 0
        arr[1] = 0
    }
    
    for(i in 2 .. m) {
        if(arr[i] == 0) { continue }
        for(j in i + i .. m step i) {
            arr[j] = 0
        }
    }

    for(i in n .. m) {
        if(arr[i] != 0) {
            min = min(min, arr[i])
            sum += arr[i]
        }
    }

    if(sum == 0) {
        print(-1)
    } else {
        println(sum)
        print(min)
    }
}