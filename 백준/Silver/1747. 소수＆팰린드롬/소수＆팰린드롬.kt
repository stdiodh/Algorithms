import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()

    val max = 2_000_000
    val arr = IntArray(max) { it }
    val primeList = mutableListOf<Int>()
    
    arr[0] = 0
    arr[1] = 0

    for (i in 2 until max) {
        if (arr[i] == 0) continue
        primeList.add(arr[i])
        for (j in i+i until max step i) {
            arr[j] = 0
        }
    }

    var ans = -1
    for (i in primeList) {
        if (i >= n && i.toString().reversed() == i.toString()) {
            ans = i
            break
        }
    }

    print(ans)
}