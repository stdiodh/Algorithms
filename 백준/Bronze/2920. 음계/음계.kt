import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt() : Int { nextToken(); return nval.toInt() }
    val sb = StringBuilder()

    val numbers = IntArray(8) { readInt() }
    val decNumbers = IntArray(8) { it+1 }
    val descNumbers = IntArray(8) { 0 }

    var count = 0
    for(j in 7 downTo 0) {
        count++
        descNumbers[j] = count
    }

    if(numbers.contentEquals(decNumbers)) {
        sb.appendLine("ascending")
    } else if (numbers.contentEquals(descNumbers)) {
        sb.appendLine("descending")
    } else {
        sb.appendLine("mixed")
    }

    print(sb)
}