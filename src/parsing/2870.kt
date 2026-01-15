package BOJ.parsing


import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine()!!.toInt()
    val numbers = mutableListOf<BigInteger>()

    repeat(n) {
        val line = br.readLine()!!

        // 정규식으로 연속된 숫자 부분 전부 찾기
        Regex("\\d+").findAll(line).forEach { matchResult ->
            val numStr = matchResult.value.trimStart('0')
            // 모두 0이면 "0" 처리
            val cleanNumStr = if (numStr.isEmpty()) "0" else numStr

            numbers.add(BigInteger(cleanNumStr))
        }
    }

    // 숫자 크기 기준 오름차순 정렬
    numbers.sort()

    // 출력
    for (num in numbers) {
        println(num)
    }
}
