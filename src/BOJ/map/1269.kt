package BOJ.map

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val a = nextInt(); val b = nextInt()

    val aArr = mutableSetOf<Int>()
    val bArr = mutableSetOf<Int>()

    repeat(a){
        aArr.add(nextInt())
    }

    repeat(b){
        bArr.add(nextInt())
    }

    print(aArr.subtract(bArr).size + bArr.subtract(aArr).size)

}