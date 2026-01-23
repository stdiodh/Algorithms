import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt() : Int { nextToken(); return nval.toInt() }
    fun readString() : String { nextToken(); return sval }

    val n = readInt()
    val sb = StringBuilder()

    repeat(n) {
        val line = readString().toCharArray()
        var result = 0
        var count = 0

        for(c in line) {
            if(c == 'O'){
                count++
                result += count
            }

            if(c == 'X'){
                count = 0
            }
        }
        sb.appendLine(result)
    }
    print(sb)
}