package BOJ.DivMul

import java.io.StreamTokenizer
import kotlin.math.sqrt

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val t = nextInt()
    val primeArr = BooleanArray(1000001) { true }
    primeArr[0] = false; primeArr[1] = false

    for(i in 2 .. sqrt(1000000f).toInt()){
        if(!primeArr[i]) continue
        for(j in i + i .. 1000000 step i){
            primeArr[j] = false
        }
    }

    repeat(t){
        val n = nextInt()
        var cnt = 0

        for(x in 2..n / 2){
            if(primeArr[x] && primeArr[n - x]){
                cnt++
            }
        }
        println(cnt)
    }
}