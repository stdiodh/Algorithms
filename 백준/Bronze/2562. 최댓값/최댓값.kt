import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }

    val arr = IntArray(9) { readInt() }
    var max = 0
    var idx = 0

    repeat(arr.size) {
        if(arr[it] > max){
            max = arr[it]
            idx = it
        }
    }

    println(max)
    println(idx + 1)
}