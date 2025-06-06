package BOJ.DivMul

import java.io.StreamTokenizer
import kotlin.math.sqrt

//import java.io.StreamTokenizer
//
//fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
//    fun nextInt() : Int { nextToken(); return nval.toInt() }
//
//    val primeArr = BooleanArray(246913) { true }
//    primeArr[0] = false; primeArr[1] = false
//
//    for(x in 2 until 246913){
//        if(x % 2 == 0){
//            primeArr[x] = false
//        }
//        for(y in x+x until 246913 step x){
//            primeArr[y] = false
//        }
//    }
//
//    while(true){
//        val n = nextInt()
//        if(n == 0){
//            break
//        }
//        if(n == 1){
//            println(1)
//            continue
//        }
//        var cnt = 0
//
//        for(x in n+1 .. 2 * n){
//            if(primeArr[x]){
//                cnt++
//            }
//        }
//        println(cnt)
//    }
//}

//메모리 개선 (제곱근 까지만 계산해도 되는데 끝까지 연산했기 때문에 메모리가 늘어났음.)
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val arr = BooleanArray(123456 * 2 + 1) { false }
    arr[1] = true
    val sb = StringBuilder()

    for(i in 2 .. sqrt(123456f * 2).toInt()){
        if(i % 2 == 0) arr[i] = true
        for(j in i+i .. 123456 * 2 step i){
            arr[j] = true
        }
    }

    while(true){
        val n = nextInt()
        if(n == 0) break
        if(n == 1) {
            sb.appendLine(1)
            continue
        }
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