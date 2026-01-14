import java.io.StreamTokenizer
import java.util.ArrayList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }
    val bw = System.out.bufferedWriter()
    val n = nextInt()
    val arr = ArrayList<Int>(n)
    val sb = StringBuilder()

    repeat(n){
        arr.add(nextInt())
    }
    arr.sort()

    arr.forEach { sb.appendLine(it) }
    bw.write(sb.toString())
    bw.close()
}