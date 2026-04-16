import kotlin.math.sqrt

class Solution {

    fun solution(number: Int, limit: Int, power: Int): Int {
        val divCnt = Array<Int>(number) { 0 }

        for (i in 1..number) {
            var cnt = 0

            for (j in 1..sqrt(i.toDouble()).toInt()) {
                if (i % j == 0) {
                    cnt += if (j * j == i) {
                        1
                    } else {
                        2
                    }
                }
            }

            divCnt[i - 1] = cnt
        }

        for(i in divCnt.indices) {
            if(divCnt[i] > limit) {
                divCnt[i] = power
            }
        }

        return divCnt.fold(0) { total, i -> total + i }
    }
}