package Programmers.Kotlin

class `7의 개수` {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        repeat(array.size){
            var num = array[it].toString()
            for(x in 0 until num.length){
                if(num[x] == '7'){
                    answer += 1
                }
            }
        }
        return answer
    }
}