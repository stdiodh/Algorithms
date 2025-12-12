import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }
    fun gcd(a : Int, b : Int) : Int {
        return if (b == 0){
            a
        } else {
            gcd (b, a % b)
        }
    }

    val n = nextInt()
    val tree = IntArray(n) { nextInt() }
    val diff = IntArray(n-1) { i -> tree[i+1] - tree[i] }

    var currGcd = diff[0]
    for(i in 1 until n-1){
        currGcd = gcd(currGcd, diff[i])
    }

    var cnt = 0
    for(j in diff){
        cnt += j / currGcd - 1
    }
    print(cnt)
}