import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val arr = IntArray(n) { nextInt() }

    var cnt = 0
    for(x in arr.size - 1 downTo 1){
        if(arr[x] <= arr[x-1]){
            cnt += arr[x-1] - (arr[x] - 1)
            arr[x-1] = arr[x] - 1
        }
    }
    print(cnt)
}