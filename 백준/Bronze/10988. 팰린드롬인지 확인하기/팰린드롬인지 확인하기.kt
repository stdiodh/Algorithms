import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt(): Int {
        nextToken(); return nval.toInt()
    }

    fun readString(): String {
        nextToken(); return sval
    }

    val str = readString()
    var start = 0
    var end = str.length - 1
    var flag = true
    while (start < end) {
        if (str[start] != str[end]) {
            flag = false
            break
        }

        start += 1
        end -= 1
    }
    
    print(if(flag) 1 else 0)
}