import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextString() : String {
        nextToken()
        return sval
    }

    val str = nextString()
    val lineNum = str.length / 10
    val sb = StringBuilder()
    for(i in 1..lineNum) {
        sb.appendLine(str.substring((i-1)*10, i*10))
    }

    sb.appendLine(str.substring(lineNum*10))
    println(sb)
}