package BOJ.pSum

//import java.io.StreamTokenizer
//import kotlin.math.min
//
//fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
//    fun i() : Int { nextToken(); return nval.toInt() }
//    fun s() : String { nextToken(); return sval }
//
//    val n = i(); val m = i(); val k = i()
//    val chaseMap = Array(n) { s() }
//    var ans = n * m
//
//    for(x in 0 until n - (k - 1)){
//        for (y in 0 until m - (k - 1)){
//            var w = 0
//            var b = 0
//
//            for(dx in x until x + k){
//                for(dy in y until y + k){
//                    if((dx+dy) % 2 == 0){
//                        if(chaseMap[dx][dy] == 'B'){
//                            w += 1
//                        } else {
//                            b += 1
//                        }
//                    } else {
//                        if(chaseMap[dx][dy] == 'W'){
//                            w += 1
//                        } else {
//                            b += 1
//                        }
//                    }
//                }
//            }
//            ans = min(ans, min(w, b))
//        }
//    }
//    print(ans)
//}

import java.io.StreamTokenizer
import kotlin.math.min

/**
 * 1. 입력을 받는다.
 * 2. 체스판을 일차원 배열로 받아주고 누적합을 구해준다. (이 때 누적합은 체스판이 B가 먼저 오는 경우와 W가 먼저오는 경우가 있으니
 * z축까지 이용하여 두가지 경우의 누적합을 각각 생성해준다.)
 * 3. 체스판을 다시 칠해야하는 칸은 1개의 횟수를 카운트한다. (색이 다른 경우 1이 더해져야하고 같은 경우에는 더할 필요가 없다.)
 * 예를 들어 (1, 1)이 흰색으로 시작하는 체스판이면 (1, 3), (2, 2), (2, 4) ... 합쳐서 짝수인 좌표는 모두 흰색이여야 한다.
 * 즉 (x+y) % 2에 따라 어떤 색인지 판단하고 실제 색과 다르면 다시 칠해야 하므로 1을 더한다.
 * 이 때 pSum[x][y][0]은 W로 시작하는 체스판 기준 고쳐야 할 칸 수 pSum[x][y][1]은 같은 범위에서 B로 시작하는 체스판 기준에서 고쳐야할 수다.
 * 4. 탐색은 k * k 크기의 사각형을 잡고 두 체스판 기준 각각의 다시 칠해야하는 칸수를 구한다.
 * 그 중 최소값을 ans에 저장한다.
 * 5. 출력한다.
 */

//fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
//    fun i(): Int { nextToken(); return nval.toInt() }
//    fun s(): String { nextToken(); return sval }
//
//    //1
//    val n = i(); val m = i(); val k = i()
//    //2
//    val board = Array(n) { s() }
//    val pSum = Array(n+1) { Array(m+1) { IntArray(2) { 0 } } }
//
//    //3
//    for(x in 1 .. n){
//        for(y in 1 .. m){
//            repeat(2){z ->
//                pSum[x][y][z] = pSum[x][y-1][z] + pSum[x-1][y][z] - pSum[x-1][y-1][z]
//            }
//            if((x+y) % 2 == 0){
//                if(board[x-1][y-1] == 'B'){
//                    pSum[x][y][0] += 1
//                } else {
//                    pSum[x][y][1] += 1
//                }
//            } else {
//                if(board[x-1][y-1] == 'W'){
//                    pSum[x][y][0] += 1
//                } else {
//                    pSum[x][y][1] += 1
//                }
//            }
//        }
//    }
//
//    //4
//    var ans = Int.MAX_VALUE
//    for(x in 1 .. n - k + 1){
//        for(y in 1 .. m - k + 1){
//            val x1 = x
//            val y1 = y
//            val x2 = x + k - 1
//            val y2 = y + k - 1
//
//            //다시 칠해야하는 누적합의 최소를 비교
//            repeat(2){z ->
//                val result = pSum[x2][y2][z] - pSum[x1 - 1][y2][z] - pSum[x2][y - 1][z] + pSum[x1 - 1][y1 - 1][z]
//                ans = min(ans, result)
//            }
//        }
//    }
//    //5
//    print(ans)
//}

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }
    fun s() : String { nextToken(); return sval }

    val n = i(); val m = i(); val k = i()
    val board = Array(n) { s() }
    val black = Array(n+1) { IntArray(m+1) { 0 } }
    val white = Array(n+1) { IntArray(m+1) { 0 } }

    for(x in 1 .. n){
        for(y in 1 .. m){
            black[x][y] = black[x][y-1] + black[x-1][y] - black[x-1][y-1]
            white[x][y] = white[x][y-1] + white[x-1][y] - white[x-1][y-1]

            if((x+y) % 2 == 1){
                if(board[x-1][y-1] == 'B'){
                    black[x][y] += 1
                } else {
                    white[x][y] += 1
                }
            } else {
                if(board[x-1][y-1] == 'W'){
                    black[x][y] += 1
                } else {
                    white[x][y] += 1
                }
            }
        }
    }

    var ans = Int.MAX_VALUE
    for(x in 1 .. n - k + 1){
        for(y in 1 .. m - k + 1){
            val x1 = x
            val y1 = y
            val x2 = x + k - 1
            val y2 = y + k - 1

            val bResult = black[x2][y2] - black[x1-1][y2] - black[x2][y1-1] + black[x1-1][y1-1]
            val wResult = white[x2][y2] - white[x1-1][y2] - white[x2][y1-1] + white[x1-1][y1-1]

            ans = min(ans, min(bResult, wResult))
        }
    }
    print(ans)
}