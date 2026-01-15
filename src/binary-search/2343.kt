package BOJ.BinarySearch

import java.io.StreamTokenizer

/**
 *
 * 1. 입력을 받는다. (n개의 강의, m개의 블루레이 크기, n개 강의의 배열)
 * 2. 강의 배열의 최댓값을 start로 그 배열을 다 더한 값의 end로 두고 이분탐색을 하여
 * 값의 중간값을 찾고 cnt를 1 올려주는 식으로 블루레이 m개를 만들어준다.
 * 3. 여기서 cnt <= m에 다다르면 모든 등분을 다 해준 것이므로 start를 출력한다.
 */

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val m = i()
    val classArr = IntArray(n) { i() }
    var start = classArr.max()
    var end = classArr.sum()

    while(start < end){
        var cnt = 1
        val mid = (start + end) / 2
        var sum = 0
        for(num in classArr){
            if(sum + num <= mid){
                sum += num
            } else {
                sum = num
                cnt++
            }
        }
        if(cnt <= m){
            end = mid
        } else {
            start = mid + 1
        }
    }
    print(start)
}