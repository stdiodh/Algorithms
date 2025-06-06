package BOJ.DivMul

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt(); val m = nextInt()
    val primeArr = BooleanArray(10000001) { true }
    val sb = StringBuilder()

    for(x in 2 .. m){
        if(x % 2 == 0){
            primeArr[x] = false
        }
        for(y in x + x .. m step x){
            primeArr[y] = false
        }
    }

    for(z in n .. m){
        if(z == 1){
            continue
        }
        if(z == 2){
            sb.appendLine(2)
        }
        if(primeArr[z]){
            sb.appendLine(z)
        }
    }

    println(sb)
}


// 메모리 개선
//import java.io.StreamTokenizer
//import kotlin.math.sqrt
//
//fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
//    fun nextInt() : Int { nextToken(); return nval.toInt() }
//
//    val n = nextInt(); val m = nextInt()
//    val primeArr = BooleanArray(m + 1) { true }
//    primeArr[0] = false; primeArr[1] = false
//
//    val sb = StringBuilder()
//
//    for(i in 2..sqrt(m.toDouble()).toInt()){
//        if (primeArr[i]) {
//            for(j in i * i .. m step i){
//                primeArr[j] = false
//            }
//        }
//    }
//
//    for(z in n .. m){
//        if(primeArr[z]){
//            sb.appendLine(z)
//        }
//    }
//
//    println(sb)
//}