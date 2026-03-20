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
        var minIdx = i
        for(j in i until num.size) {
            if(num[minIdx] < num[j]) {
                minIdx = j
            }
        }
        val temp = num[minIdx]
        num[minIdx] = num[i]
        num[i] = temp
    }

    print(num.joinToString(""))
}
