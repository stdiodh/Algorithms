import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }
    val n = readInt()
    var result = 1L

    if(n == 0) {
        result = 1
    } else {
        for(i in n downTo 1 step 1) {
            result *= i
        }
    }

    print(result)
}