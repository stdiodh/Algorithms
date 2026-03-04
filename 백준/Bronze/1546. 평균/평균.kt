import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val scoreArr = IntArray(n) { i() }
    val max = scoreArr.max().toDouble()
    val result : Double = scoreArr.sum() * 100 / max / scoreArr.size
    println(result)
}

