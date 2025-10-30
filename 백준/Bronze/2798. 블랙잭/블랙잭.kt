package BOJ

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val target = i()
    val cardArray = IntArray(n) { i() }
    var ans = 0

    for(i in 0 ..< n - 2) {
        for(j in i + 1 ..< n - 1){
            for(k in j + 1 ..< n){
                val sum = cardArray[i] + cardArray[j] + cardArray[k]

                if (sum <= target && sum > ans) {
                    ans = sum
                }

                if (ans == target) {
                    break
                }
            }
        }
    }
    print(ans)
}