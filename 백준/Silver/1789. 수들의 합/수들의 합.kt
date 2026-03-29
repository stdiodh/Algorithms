import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextLong() : Long { nextToken(); return nval.toLong() }

    val n = nextLong()
    var cnt = 0
    var ans = 0L

    while (true){
        cnt++
        ans += cnt
        if(ans > n){
            cnt--
            break
        }
    }
    print(cnt)
}