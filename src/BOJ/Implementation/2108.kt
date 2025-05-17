package BOJ.Implementation

import java.io.StreamTokenizer
import kotlin.math.round

//넷째 범위 = 마지막 - 첫 값

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val arr = IntArray(n) { nextInt() }.sortedArray()
    val sb = StringBuilder()

    //첫줄 산술 평균 = (총합) / 수의 갯수
    val total = arr.reduce { total, num -> total + num }
    sb.appendLine(round(total.toDouble() / n).toInt())

    //둘째 중앙값 = 정렬된 배열의 중앙
    val mid = (n / 2)
    sb.appendLine(arr[mid])

    //셋째 최빈값 = 정렬에 숫자별로 가져오는데 그 수가 최빈 값을 넘어가면 갱신
    //여러개면 최빈값 중 두 번째로 작은 값
    val mostArr = arr.groupBy { it }.mapValues { it.value.count() }
    val maxFreq = mostArr.maxOf { it.value }
    val modes = mostArr.filterValues { it == maxFreq }.keys.sorted()
    val three = if (modes.size >= 2) modes[1] else modes[0]
    sb.appendLine(three)

    //넷째 범위 = 마지막 - 첫 값
    val four = arr[n-1] - arr[0]
    sb.appendLine(four)
    print(sb)
}