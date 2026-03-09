import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt(); val m = nextInt()
    val sb = StringBuilder()

    val matrix1 = Array(n) { IntArray (m) { nextInt() } }
    val matrix2 = Array(n) { IntArray (m) { nextInt() } }
    val sumMatrix = Array(n) { IntArray(m) { 0 } }

    for(i in 0 ..< n) {
        for(j in 0 ..< m) {
            sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j]
        }
    }

    for(i in 0 ..< n) {
        for(j in 0 ..< m) {
            sb.append("${sumMatrix[i][j]} ")
        }
        sb.appendLine()
    }

    print(sb)
}
