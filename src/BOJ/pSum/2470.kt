package BOJ.pSum

import java.io.StreamTokenizer
import kotlin.math.*


/**
 * 이번 문제의 중요한 점은 두 개의 용액을 더해 0에 가까운 두 값을 출력해야 하는 문제이다,
 * 때문에 투포인터와 함께 절대값의 개념을 사용할 것이다.
 * 만약 두 값을 더해 절대값이 0에 가깝다면 그 값을 ans에 저장하고 0에 도달했다면
 * 그 값은 산성 알칼리성의 최소값이므로 반복을 멈춘다.
 * 1. 입력을 받는다. (n은 배열의 크기, arr은 n개의 배열 대신 투포인터를 사용하기 위해서 정렬은 필수)
 * 2. 투포인터는 처음과 끝을 집고 좁혀가면서 더함 (위의 설명대로 더한 값이 0에 가까운 것을 저장하며 초기화해줌)
 * 3. 모두 돌면서 0에 도달하면 멈춤
 * 4. left가 right를 넘지 않을때까지 값을 갱신 해주며 반복이 끝나면 값을 출력함
 */


fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val arr = IntArray(n) { i() }.sortedArray()

    var left = 0; var right = n - 1
    var ans = Int.MAX_VALUE
    //정답 배열의 인덱스(초기 투포인터의 처믕과 끝)
    val result = intArrayOf(0, n-1)
    while(left < right){
        val sum = arr[left] + arr[right]
        if(ans > abs(sum)){
            ans = abs(sum)
            result[0] = arr[left]
            result[1] = arr[right]

            if(sum == 0){
                break
            }
        }

        if(ans > sum){
            left++
        } else {
            right--
        }
    }

    print(result.joinToString(" "))
}