package BOJ.pSum

/**
 * BOJ 13900
 *
 * 1. 원소의 갯수 n과 n개에 해당하는 배열 받기
 * 2. 누적합 구하기
 * 3. 순서쌍의 곱은 1부터 i번째 수와 N번째 수까지의 합의 곱을 더해주면 나옴.
 * 1부터 i번째 수 pSum[n] - pSum[it + 1], N번째 수까지의 합 arr[it]
 * arr[it] * (pSum[n] - pSum[it + 1])
 * 4. 결과를 출력
 * 참고, 수의 범위가 100_000 * 10_000 이니 pSum은 LongArray로 구현
 */

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    //1
    val n = i()
    val arr = IntArray(n) { i() }
    //2
    val pSum = LongArray(n+1) { 0 }
    repeat(n){
        pSum[it+1] = pSum[it] + arr[it]
    }

    //3
    var result = 0L
    repeat(n){
        result += arr[it] * (pSum[n] - pSum[it + 1])
    }
    //4
    print(result)
}