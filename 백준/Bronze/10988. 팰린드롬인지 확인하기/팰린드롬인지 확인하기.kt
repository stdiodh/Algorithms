import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }
    fun readString() : String { nextToken(); return sval }

    val str = readString()
    
    if(str == str.reversed()) {
        print("1")
    } else {
        print("0")
    }
}