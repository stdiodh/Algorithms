import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }

    val n = readInt(); val x = readInt()
    val arr = IntArray(n) { readInt() }
    val sb = StringBuilder()

    repeat(arr.size) {
        if(x > arr[it]){
            sb.append("${arr[it]} ")
        }
    }

    print(sb)
}