import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }
    val i = readInt()
    val sb = StringBuilder()

    repeat(i) { i ->
        sb.appendLine("*".repeat(i+1))
    }
    print(sb)
}