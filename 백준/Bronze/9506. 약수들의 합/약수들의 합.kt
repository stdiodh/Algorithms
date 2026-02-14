import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i(): Int { nextToken(); return nval.toInt() }

    while(true) {
        val n = i()
        if (n == -1) {
            break
        }
        var cnt = 0
        val numList = mutableListOf<Int>()

        for (i in 1..< n) {
            if (n % i == 0) {
                cnt += i
                numList.add(i)
            }
        }

        if (cnt == n) {
            print("$n = ")
            print(numList.joinToString(" + "))
            println()
        } else {
            println("$n is NOT perfect.")
        }
    }
}