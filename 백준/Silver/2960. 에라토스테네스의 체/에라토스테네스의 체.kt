import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val k = i()

    val arr = IntArray(n+1) { it }
    var cnt = 0
    val sb = StringBuilder()

    for (x in 2 .. n) {
        if (arr[x] != 0) {
            for (y in x .. n step x) {
                if (arr[y] != 0){
                    arr[y] = 0
                    cnt++
                }
                if (cnt == k) {
                    sb.appendLine(y)
                    break
                }
            }
        }

        if (cnt == k) {
            break
        }
    }
    print(sb)
}