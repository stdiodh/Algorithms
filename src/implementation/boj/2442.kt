import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }

    val n = readInt()
    val sb = StringBuilder()
    var count = n - 1

    for(i in 1 .. n) {
        repeat(i) {
             sb.append(" ")
         }

        sb.append("*".repeat(i))

        repeat(i) {
            sb.append("")
        }
        sb.appendLine()
        count--
    }

    print(sb)
}
