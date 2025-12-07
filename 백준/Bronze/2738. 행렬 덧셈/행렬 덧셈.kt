import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int {
        nextToken()
        return nval.toInt()
    }

    val n = nextInt(); val m = nextInt()

    val arr1 = Array(n) { IntArray(m) {nextInt()} }
    val arr2 = Array(n) { IntArray(m) {nextInt()} }

    val sb = StringBuilder()
    repeat(n){idx ->
        repeat(m){jdx ->
            sb.appendLine(arr1[idx][jdx] + arr2[idx][jdx])
        }
    }
    println(sb)
}