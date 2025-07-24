package BOJ.pSum

/**
 * 내가 접근한 방법
 * 1. 초기값을 입력받는다.
 * 2. 맵의 크기대로 값을 배열에 저장한다. (이 때 짝수는 석순이니 바닥에서 올라오게 하고 홀수는 종유석이니 위에서 내려오게 만들어준다.)
 * 3. 맵의 행 별 누적합을 구해 계산한다.
 * 4. 누적합 중 가장 작은 충돌 횟수와 그 카운트를 해시에 저장하여 뽑는다.
 * 5. 출력한다.
 * -> 이렇게 되면 2차원 배열을 그리기 때문에 배열의 크기가 (200_000 * 500_000) 까지 들어오기 때문에
 * 메모리 초과가 발생한다.
 */

//import java.io.StreamTokenizer
//
//fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
//    fun i() : Int { nextToken(); return nval.toInt() }
//
//    //1
//    val n = i(); val h = i()
//    //2
//    val map = Array(h) { IntArray(n) { 0 } }
//    repeat(n){idx ->
//        val num = i()
//        if(idx % 2 == 0){
//            for(t in h - 1 downTo h - num){
//                map[t][idx] = 1
//            }
//        } else {
//            for(i in 0 until num){
//                map[i][idx] = 1
//            }
//        }
//    }
//
//    //3
//    val rowSum = IntArray(h) { 0 }
//    repeat(h){h ->
//        var sum = 0
//        repeat(n){n ->
//            sum += map[h][n]
//        }
//        rowSum[h] = sum
//    }
//
//    //4
//    val hash = HashMap<Int, Int>()
//    rowSum.forEach { sum ->
//        hash[sum] = hash.getOrDefault(sum, 0) + 1
//    }
//
//    //5
//    val result = hash.toSortedMap().toList().first()
//    print("${result.first} ${result.second}")
//}

/**
 * 위의 방법이 메모리 초과가 뜨기 때문에
 * 배열을 1차원 배열로 바꿀 필요가 있다.
 * 1. 초기값을 받는다.
 * 2. 석순과 종유석의 장애물 위치를 받아준다. (마찬가지로 짝수일 때 바닥에서 올라오도록 홀수일 때 천장에서 내려오도록 만든다.)
 * 3. 이 때 충돌하는 장애물 수의 누적합 배열을 1차원 배열로 만들어준다.
 * 4. 이후 충돌하는 높이에 따른 장애물 수를 구해준다. (최솟값만 저장하여 최솟값을 넘지 않으면 갱신되지 않는다.)
 * 5. 구한 값을 출력한다.
 */

//import java.io.StreamTokenizer
//
//fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
//    fun i(): Int { nextToken(); return nval.toInt() }
//
//    //1
//    val n = i()
//    val h = i()
//    val bottom = IntArray(h + 1)
//    val top = IntArray(h + 1)
//
//    //2
//    repeat(n) { idx ->
//        val num = i()
//        if (idx % 2 == 0) {
//            bottom[num]++
//        } else {
//            top[num]++
//        }
//    }
//
//    //3
//    for (i in h - 1 downTo 1) {
//        bottom[i] += bottom[i + 1]
//        top[i] += top[i + 1]
//    }
//
//    //4
//    var min = Int.MAX_VALUE
//    var count = 0
//    for (height in 1..h) {
//        val crush = bottom[height] + top[h - height + 1] // 현재 높이에서 충돌하는 장애물 수
//
//        when {
//            crush < min -> {
//                min = crush
//                count = 1
//            }
//
//            crush == min -> {
//                count++
//            }
//        }
//    }
//
//    //5
//    println("$min $count")
//}

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i(): Int {
        nextToken(); return nval.toInt()
    }

    val n = i(); val h = i()
    val line = IntArray(h)
    repeat(n){
        val size = i()
        if (it % 2 == 0){
            line[h - size]++
        } else {
            line[0]++
            line[size] -= 1
        }
    }

    for(i in 1 until h){
        line[i] += line[i - 1]
    }

    val ans = line.min()
    var cnt = 0
    for(i in line){
        if(i == ans){
            cnt+=1
        }
    }
    print("$ans $cnt")
}