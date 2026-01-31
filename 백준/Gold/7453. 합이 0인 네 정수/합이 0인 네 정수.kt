import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val aArr = IntArray(n) { 0 }
    val bArr = IntArray(n) { 0 }
    val cArr = IntArray(n) { 0 }
    val dArr = IntArray(n) { 0 }

    repeat(n){
        val a = i(); val b = i(); val c = i(); val d = i()
        aArr[it] = a; bArr[it] = b; cArr[it] = c; dArr[it] = d
    }

    val AB = IntArray(n*n) { 0 }
    val CD = IntArray(n*n) { 0 }

    var idx = 0
    repeat(n){i ->
        repeat(n){j ->
            AB[idx] = aArr[i] + bArr[j]
            CD[idx] = cArr[i] + dArr[j]
            idx++
        }
    }
    AB.sort()
    CD.sort()

    var left = 0; var right = n*n - 1
    var ans = 0L
    while(left < n*n && right >= 0){
        val sum = AB[left] + CD[right]
        if(sum < 0){
            left++
        } else if(sum > 0) {
            right--
        } else {
            var leftCnt = 1L; var rightCnt = 1L
            while(left+1 < n*n && (AB[left] == AB[left+1])){
                leftCnt++
                left++
            }
            while(right > 0 && (CD[right] == CD[right-1])){
                rightCnt++
                right--
            }
            ans += leftCnt * rightCnt
            left++
        }
    }
    print(ans)
}