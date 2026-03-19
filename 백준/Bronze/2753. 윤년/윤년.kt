import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }

    val year = readInt()
    if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        print("1")
    } else {
        print("0")
    }

}