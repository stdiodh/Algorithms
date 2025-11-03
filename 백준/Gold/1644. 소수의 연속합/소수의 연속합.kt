import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val numArr = IntArray(n+1) { it }

    var cnt = 0

    for(i in 2..n) {
        if (numArr[i] == 0) continue
        for(j in i + i .. n step i) {
            numArr[j] = 0
        }
    }

    val primeList = numArr.filter { it != 0 && it != 1 }

    if(primeList.isEmpty()) {
        print(0)
    } else {
        var sum = primeList[0]
        var start = 0; var end = 0
        while (end < primeList.size) {
            if (sum == n) {
                cnt++
                sum -= primeList[start]
                start++
            } else if (sum < n) {
                end++
                if (end < primeList.size) {
                    sum += primeList[end]
                }
            } else {
                sum -= primeList[start]
                start++
            }
        }
        print(cnt)
    }
}