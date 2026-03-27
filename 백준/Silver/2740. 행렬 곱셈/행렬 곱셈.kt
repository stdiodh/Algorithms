import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt(): Int {
        nextToken(); return nval.toInt()
    }

    fun readString(): String {
        nextToken(); return sval
    }

    val aN = readInt(); val aM = readInt()
    val matrix1 = Array(aN) { IntArray (aM) { readInt() } }

    val bN = readInt(); val bM = readInt()
    val matrix2 = Array(bN) { IntArray(bM) { readInt() } }

    val malMatrix = Array(aN) { IntArray(bM) { 0} }



    repeat(aN) { i ->
        repeat(matrix2[0].size) { j ->
            repeat(matrix1[0].size) { k ->
                malMatrix[i][j] += matrix1[i][k] * matrix2[k][j]
            }
        }
    }

    malMatrix.forEach { println(it.toList().joinToString(" ")) }
}
