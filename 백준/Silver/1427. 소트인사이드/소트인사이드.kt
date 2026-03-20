import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt(): Int {
        nextToken(); return nval.toInt()
    }

    fun readString(): String {
        nextToken(); return sval
    }

    val num = readInt().toString().toCharArray()

    for(i in 0 .. num.size - 1) {
        for(j in i until num.size) {
            if(num[i] < num[j]) {
                val temp = num[i]
                num[i] = num[j]
                num[j] = temp
            }
        }
    }

    print(num.joinToString(""))
}