import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt(): Int {
        nextToken(); return nval.toInt()
    }

    fun readString(): String {
        nextToken(); return sval
    }

    val n = readInt()
    val intArr = IntArray(n) { readInt() }

    for(i in 0 .. intArr.size - 1) {
        var minIndex = i
        for(j in i + 1 until intArr.size) {
            if(intArr[j] < intArr[minIndex]) {
                minIndex = j
            }
        }
        val temp = intArr[minIndex]
        intArr[minIndex] = intArr[i]
        intArr[i] = temp
    }

    intArr.forEach { println(it) }
}