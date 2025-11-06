import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int {
        nextToken()
        return nval.toInt()
    }

    val n = nextInt(); val m = nextInt()
    val arr = IntArray(n){
        nextInt()
    }
    arr.sort()

    var left = 0; var right = n - 1
    var ans = 0
    while(left < right){
        val sum = arr[left] + arr[right]
        if(sum == m){ ans += 1 }
        if (sum < m) { left += 1 }
        else { right -= 1 }
    }
    println(ans)
}