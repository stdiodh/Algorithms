package BOJ.slidingWindow

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val x = i()
    val blog = IntArray(n) { i() }

    var sum = 0
    repeat(x){
        sum += blog[it]
    }

    var max = sum
    var cnt = 1
    for(i in x until n){
        sum += blog[i] - blog[i-x]

        if(max < sum){
            max = sum
            cnt = 1
        } else if (max == sum){
            cnt++
        }
    }

    if(max == 0){
        print("SAD")
    } else {
        println(max)
        print(cnt)
    }
}