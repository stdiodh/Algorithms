import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }
    fun s() : String { nextToken(); return sval }

    val s = s()
    val q = i()
    val sb = StringBuilder()
    val pSumStr = Array(s.length + 1) { IntArray(26) { 0 } }

    repeat (s.length) { i ->
        val charIdx = s[i].code - 'a'.code
        repeat(26) { j ->
            pSumStr[i+1][j] = pSumStr[i][j] + (if (j == charIdx) 1 else 0)
        }
    }

    repeat (q) {
        val target = s()[0]; val l = i(); val r = i()
        val charIdx = target.code - 'a'.code
        val result = pSumStr[r+1][charIdx] - pSumStr[l][charIdx]
        sb.appendLine(result)
    }
    print(sb)
}