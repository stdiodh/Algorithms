package BOJ.DP

import java.io.StreamTokenizer
import kotlin.math.max

/**
 * 이 문제는 정수의 삼각형 배열을 받고 이 값이 아래층 대각선 왼쪽과 오른쪽 중 선택하여 가장 큰 값을 찾아가는 문제이다.
 * 여기서 Greedy로 접근하게 되면 최적의 해를 찾지 못하기 때문에 우리는 DP를 사용해야한다.
 * 또 DP를 사용하기 위해서는 우리는 관점을 위에서 아래가 아닌 아래에서 위로 올라갈 생각을 해야한다.
 * 만약 삼각형의 아랫 2번째 칸에서 시작을 한다면?
 * 우리는 arr[i][j]가 있다면 ]arr[i+1][j]와 arr[i+1][j+1] 이 두 개를 해당 위치에서 더했을 때 큰 값이 우리의 해를 찾아가는 과정일 것이다.
 * 이 과정을 통해 Bottom-Up을 하게되면 최적의 해를 찾을 수 있을 것이다.
 * 그리고 정답은 배열 맨 위에 존재할 것이다.
 */

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val arr = Array(n) { IntArray(n) { 0 } }

    repeat(n){ i ->
        repeat(n){ j ->
            if(j > i){
                return@repeat
            }
            arr[i][j] = i()
        }
    }

    for(i in n-2 downTo 0){
        for(j in 0 .. n-2){
            arr[i][j] = arr[i][j] + max(arr[i+1][j], arr[i+1][j+1])
        }
    }
    print(arr[0][0])
}