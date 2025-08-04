package BOJ.slidingWindow

import java.io.StreamTokenizer

/**
 * 1. 입력을 받는다. (n은 총 일, x는 가장 많은 방문자를 찾는 x일 기간, 하루마다의 방문자 n일을 받을 배열)
 * 2. 첫 번째 x크기 만큼의 슬라이딩 윈도우를 지정해준다. (x일 만큼의 방문자 변수)
 * 3. 첫 번째 윈도우를 만들었으니 이후 나오는 수를 더해주고 이전 한 칸의 수를 빼준 다음 윈도우와 비교해가며 큰 부분이 방문자가 많은 배열이니
 * 그 때는 카운트를 1로 초기화해주고 만약 윈도우 값과 max 값이 같다면 카운트를 추가해주는 식으로 갱신해나간다.
 * 4. 이후 max 값이 0이라면 SAD를 출력 값이 0이 아니라면 max값과 같이 cnt값을 출력해준다.
 */

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val x = i()
    val visitArr = IntArray(n) { i() }

    var sum = 0
    repeat(x){
        sum += visitArr[it]
    }

    var max = sum
    var cnt = 1

    for(i in x until n){
        sum = sum - visitArr[i-x] + visitArr[i]

        if(sum > max){
            max = sum
            cnt = 1
        } else if(sum == max){
            cnt++
        }
    }

    if(max == 0){
        print("SAD")
    } else {
        println(max)
        print(cnt)
    }
}