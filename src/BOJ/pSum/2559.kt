package BOJ.pSum

import java.io.StreamTokenizer
import kotlin.math.max

/*
1. 입력을 받는다.
2. 누적합을 구한다.
3. 첫 범위를 연속적인 수의 순열 크기 k만큼(pSum[i])을 잡아준 뒤
이어서 나오는 누적합에 뺄셈으로 뒤에 이어 나오는 누적합(pSum[i-k])들을 구하며 이전 범위랑 다음 범위를 비교해준다.
이 때 범위는 k부터 n+1(누적합은 +1을 하기 때문)이다.
4. 이후 ans는 가장 큰 수열일테니 그것을 출력해준다.
 */

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val k = i()
    val pSum = IntArray(n+1) { 0 }

    repeat(n){
        pSum[it+1] = pSum[it] + i()
    }

    var ans = pSum[k]
    for(i in k until n+1){
        val sum = pSum[i] - pSum[i-k]
        ans = max(ans, sum)
    }
    print(ans)
}