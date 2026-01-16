import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val sb = StringBuilder()
    for(i in n downTo 1) {
        repeat(n - i){
            sb.append(" ")
        }
        repeat(i){
            sb.append("*")
        }
        sb.appendLine()
    }
    print(sb)
}
