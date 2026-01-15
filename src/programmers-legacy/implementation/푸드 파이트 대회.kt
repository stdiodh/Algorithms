package Programmers.Kotlin

class `푸드파이트대회` {
    fun solution(food: IntArray): String {
        val sb = StringBuilder()
        for(i in 1 until food.size){
            repeat(food[i] / 2){
                sb.append(i)
            }
        }
        val reversed = sb.reversed()
        sb.append(0)
        sb.append(reversed)
        return sb.toString()
    }
}