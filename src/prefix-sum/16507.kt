package BOJ.pSum

import java.io.StreamTokenizer

/**
 * 1. 입력을 받는다. (r * c 크기의 배열, q 직사각형을 받을 갯수)
 * 2. 누적합을 계산해준다.
 * 3. 직사각형의 두 꼭짓점을 받아준다. 이 때, 직사각형의 넓이는 다음과 같은 공식을 가진다.
 * (x2 - x1 + 1) * (y2 - y1 + 1) // +1을 해주는 이유는 인덱스는 0부터 시작하기 때문
 * 4. 직사각형의 총합 / 넓이를 해주면 평균 밝기를 얻을 수 있다.
 * 5. 해당 값을 출력해준다.
 */

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    //1
    val r = i(); val c = i(); val q = i()

    //2 O(r * c)
    val pSum = Array(r+1) { IntArray(c+1) { 0 } }
    repeat(r){idx ->
        repeat(c){jdx ->
            pSum[idx+1][jdx+1] = pSum[idx+1][jdx] + pSum[idx][jdx+1] - pSum[idx][jdx] + i()
        }
    }

    val sb = StringBuilder()
    repeat(q){
        //3 O(q)
        val x1 = i(); val y1 = i(); val x2 = i(); val y2 = i()
        //4
        val squareArea = (x2 - x1 + 1) * (y2 - y1 + 1)
        val squareSum = pSum[x2][y2] - pSum[x1 - 1][y2] - pSum[x2][y1 - 1] + pSum[x1 - 1][y1 - 1]
        sb.appendLine(squareSum / squareArea)
    }
    //5
    print(sb)
}