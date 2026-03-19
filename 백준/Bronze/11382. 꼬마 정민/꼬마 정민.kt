import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    val br = System.`in`.bufferedReader()
    val arr = br.readLine().split(" ")
    var result = 0L

    repeat(3) {
        result += arr[it].toLong()
    }

    print(result)
}
