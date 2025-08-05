package BOJ.slidingWindow

import java.io.StreamTokenizer
import kotlin.math.max

/**
 * 문제의 핵심은 할인 행사에 참여하여 가능한 한 다양한 종류의 초밥을 먹으려고 하는 것
 * 초밥의 종류를 체크하여 카운트 배열에 초밥을 넣어주어야 하며
 * 만약 c번 초밥이 없다면 요리사가 만들어야 한다.
 * 1. 입력을 받는다. (n 벨트 상태, d 초밥의 가짓수, k 연속해서 먹을 수, c 쿠폰 번호)
 * 2. count 배열에 초밥의 종류에 따른 갯수를 넣어주며 unique 변수를 이용하여 초밥의 가짓수를 적어준다.
 * 3. max는 처음 초밥의 가짓수를 가진다. 만약 c번째 초밥이 없다면 만들어야 하므로 1을 더해주고 아니라면 종류는 같을테니 그대로 둔다.
 * 4. 여기서 이미 첫 번째 k 만큼의 초밥 종류는 나와있을테니 슬라이딩 윈도우 알고리즘을 사용하여 처음 초밥[i % n]과 이후 들어올 초밥[(i+k) % n]을
 * 번갈아가면서 계산하며 삭제되었을 때는 종류가 사라진 것으로 --, 추가되었을 때 0이라면 종류가 많아진 것이므로 ++를 해준다.
 * 이때 쿠폰 초밥이 있는지도 확인하며 종류 수에 더해준다.
 * 이후 종류 수를 비교해 가며 최대인 종류를 구한다.
 * 5. 최대 종류 수를 출력한다.
 */

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val d = i(); val k = i(); val c = i()
    val sushiArr = IntArray(n) { i() }
    val count = IntArray(d+1)
    var uniqueCount = 0
    var max = 0

    repeat(k){
        val s = sushiArr[it % n]
        if(count[s] == 0) uniqueCount++
        count[s]++
    }

    max = if(count[c] == 0){ uniqueCount+1 } else uniqueCount

    for(i in 0 until n-1){
        val remove = sushiArr[i % n]
        val add = sushiArr[(i+k) % n]

        count[remove]--
        if(count[remove] == 0) uniqueCount--

        if(count[add] == 0) uniqueCount++
        count[add]++

        val total = if(count[c] == 0) uniqueCount+1 else uniqueCount
        max = max(max, total)
    }
    print(max)
}