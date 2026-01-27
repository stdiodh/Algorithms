import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }

    val n = readInt()
    val fibo = IntArray(46) { 0 }
    fibo[1] = 1
    fibo[2] = 1

    for(i in 3 .. 45) {
        fibo[i] = fibo[i - 1] + fibo[i - 2]
    }
    println(fibo[n])
}
