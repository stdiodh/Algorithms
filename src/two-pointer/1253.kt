package BOJ.twoPointer

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val arr = IntArray(n) { i() }.sortedArray()
    var cnt = 0

    for(k in 0 until n){
        val f = arr[k]
        var i = 0; var j = n-1
        while(i < j){
            if(arr[i] + arr[j] == f){
                if(i != k && j != k){
                    cnt++
                    break
                } else if (i == k){
                    i++
                } else {
                    j--
                }
            } else if(arr[i] + arr[j] < f) {
                i++
            } else {
                j--
            }
        }
    }
    print(cnt)
}