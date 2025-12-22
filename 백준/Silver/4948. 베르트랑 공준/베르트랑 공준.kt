import java.io.StreamTokenizer
import kotlin.math.sqrt

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val arr = BooleanArray(123456 * 2 + 1) { false }
    arr[1] = true
    val sb = StringBuilder()

    for(i in 2 .. sqrt(123456f * 2).toInt()){
        if(arr[i]) continue
        for(j in i+i .. 123456 * 2 step i){
            arr[j] = true
        }
    }

    while(true){
        val n = nextInt()
        if(n == 0) break
        var cnt = 0
        for(i in n+1 .. n*2){
            if(!arr[i]){
                cnt++
            }
        }
        sb.appendLine(cnt)
    }
    println(sb)
}