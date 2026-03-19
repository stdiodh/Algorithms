import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }
    var hh = readInt(); var mm = readInt()

    if(mm < 45) {
        hh -= 1
        mm = 60 + (mm - 45)
        if (hh < 0) {
            hh = 23
        }
    } else {
        mm = mm - 45
    }

    print("$hh $mm")
}