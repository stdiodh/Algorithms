import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt() : Int { nextToken(); return nval.toInt() }

    val n = readInt()
    val dp = IntArray(11)

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    val sb = StringBuilder()

    for(i in 4 .. 10) {
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    }

    repeat(n){
        sb.appendLine(dp[readInt()])
    }

    print(sb)
}
