package Programmers.stackQueue

import java.util.*

class 기능개발 {
    fun solution(progresses: IntArray, speeds: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        val days = LinkedList<Int>()

        for(i in progresses.indices){
            val remain = 100 - progresses[i]
            // 하루에 speeds[i]% 만큼 진척되므로, 전체 완료까지 몇 일이 필요한지 계산합니다.
            // 나머지가 없으면 딱 나누어진 값이고, 나머지가 있으면 하루 더 걸리므로 +1
            val day = if(remain % speeds[i] == 0){
                remain / speeds[i]
            } else {
                remain / speeds[i] + 1
            }
            days.add(day)
        }

        while(days.isNotEmpty()){
            val current = days.poll()
            var cnt = 1
            while(days.isNotEmpty() && days.peek() <= current){
                days.poll()
                cnt++
            }
            result.add(cnt)
        }
        return result
    }
}