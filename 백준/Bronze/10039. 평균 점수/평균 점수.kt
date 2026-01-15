import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt() : Int { nextToken(); return nval.toInt() }
    var total = 0

    repeat(5) {
        var num = readInt()
        if(num < 40) {
            num = 40
        }
        total += num
    }

    print(total / 5)
}