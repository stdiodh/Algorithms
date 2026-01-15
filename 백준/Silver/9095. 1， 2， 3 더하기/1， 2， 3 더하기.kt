import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt() : Int { nextToken(); return nval.toInt() }

    val n = readInt()
    val numArr = IntArray(n)

    repeat(n) {
        val num = readInt()
        numArr[it] = num
    }
    val max = numArr.max()
    val dp = IntArray(max+1)

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    val sb = StringBuilder()

    for(i in 4 .. max) {
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    }

    repeat(n){
        sb.appendLine(dp[numArr[it]])
    }

    print(sb)
}
