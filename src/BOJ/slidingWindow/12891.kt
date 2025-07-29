package BOJ.slidingWindow

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }
    fun s() : String { nextToken(); return sval }

    val s = i(); val p = i()
    val str = s()
    val acgt = IntArray(4) { i() }
    var ptr = p; var cnt = 0
    var a = 0; var c = 0; var g = 0; var t = 0

    repeat(p){
        when(str[it]){
            'A' -> a++
            'C' -> c++
            'G' -> g++
            'T' -> t++
        }
    }
    if(acgt[0] <= a && acgt[1] <= c && acgt[2] <= g && acgt[3] <= t){
        cnt++
    }

    while(s > ptr){
        when(str[ptr]){
            'A' -> a++
            'C' -> c++
            'G' -> g++
            'T' -> t++
        }

        when(str[ptr-p]){
            'A' -> a--
            'C' -> c--
            'G' -> g--
            'T' -> t--
        }

        if(acgt[0] <= a && acgt[1] <= c && acgt[2] <= g && acgt[3] <= t){
            cnt++
        }

        ptr++
    }
    print(cnt)
}