import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }
    fun readString() : String { nextToken(); return sval }

    val t = readInt()
    val sb = StringBuilder()

    repeat(t) {
        val str = readString()
        val fIdx = 0; val lIdx = str.length - 1

        sb.appendLine("${str[fIdx]}${str[lIdx]}")
    }

    print(sb)
}