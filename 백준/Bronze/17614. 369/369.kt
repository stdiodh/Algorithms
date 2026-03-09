import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    val num = i()
    var clap = 0

    for(i in 1 .. num) {
        var current = i
        while(current > 0) {
            val digit = current % 10
            if(digit == 3 || digit == 6 || digit == 9) {
                clap += 1
            }
            current /= 10
        }
    }

    print(clap)
}
