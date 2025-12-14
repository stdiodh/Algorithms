import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextString() : String { nextToken(); return sval }

    val s = nextString()
    val sArr = mutableListOf<String>()
    val sb = StringBuilder()

    for(x in s.indices) {
        sArr.add(s.substring(x, s.length))
    }
    sArr.sort()
    sArr.forEach { sb.appendLine(it)}
    print(sb)
}