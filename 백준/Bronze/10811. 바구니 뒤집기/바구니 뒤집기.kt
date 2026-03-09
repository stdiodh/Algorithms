import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt(); val m = nextInt()

    val intArr = IntArray(n) { it+1 }
    repeat(m) {
        var i = nextInt() - 1; var j = nextInt() - 1

        while(i < j) {
            val temp = intArr[i]
            intArr[i++] = intArr[j]
            intArr[j--] = temp
        }
    }

    intArr.forEach { print("$it ") }
}
