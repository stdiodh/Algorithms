import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }

    val arr = IntArray(readInt()) { readInt() }
    val target = readInt()
    var count = 0

    repeat(arr.size) {
        if(target == arr[it]){
            count++
        }
    }

    print(count)
}