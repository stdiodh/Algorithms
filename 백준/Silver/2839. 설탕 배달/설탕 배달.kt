import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    var n = nextInt()

    var ans = 0
    while(n >= 3){
        if(n % 5 == 0){
            n -= 5
            ans++
        } else {
            n -= 3
            ans++
        }
    }

    if(n == 0){
        print(ans)
    } else {
        print("-1")
    }
}