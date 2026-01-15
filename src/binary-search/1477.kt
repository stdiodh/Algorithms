package BOJ.BinarySearch

import java.io.StreamTokenizer

/**
 * 이 문제는 모든 휴게소 간의 거리를 가장 균등하게 만들어, 가장 긴 휴게소 간의 거리를 최소화하는 문제이다.
 * 1. 입력을 받는다. (n개의 휴게소, m개의 휴게소를 설치, 총 길이가 l인 도로)
 * 그런데 arr 배열 도로의 시작점(0)과 끝점(l)을 모두 넣고 오름차순을 해줘야한다.
 * 2. 이분탐색을 돌리는데 여기서 mid는 휴게소 간의 최대 거리이다.
 * 3. cnt는 mid 거리를 만족시기키 위한 새로 설치해야 할 휴게소의 개수이며
 * 이 값이 m을 넘어가는 순간 더 많은 휴게소가 필요하다는 뜻으로 mid에 +1을 하여 범위를 더 큰거리로 시도한다.
 * 이 값이 m 보다 작다면 거리를 달성할 수 있다는 의미로 answer 에 mid를 저장하고
 * 더 적은 최대 거리가 있는지 end에 mid-1을 해가며 거리가 더 작은 경우를 체크하고 그게 start <= end 에 닿는다면 종료한다.
 * 4. 종료되면 answer를 출력한다.
 */

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val m = i(); val l = i()
    val arr = IntArray(n+2) { 0 }
    repeat(n){
        arr[it+1] = i()
    }
    arr[n+1] = l
    arr.sort()

    var start = 1
    var end = l - 1
    var answer = l

    while(start <= end){
        val mid = (start + end) / 2
        var cnt = 0
        for(i in 1 .. arr.size - 1){
            cnt += (arr[i] - arr[i-1] - 1) / mid
        }

        if(cnt > m){
            start = mid + 1
        } else {
            answer = mid
            end = mid - 1
        }
    }
    print(answer)
}