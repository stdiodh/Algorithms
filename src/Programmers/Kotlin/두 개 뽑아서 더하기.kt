package Programmers.Kotlin

class `두개뽑아서더하기` {
    fun solution(numbers: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val sortedArr = numbers.sorted()
        repeat(numbers.size){idx ->
            repeat(numbers.size){jdx ->
                if(idx != jdx){
                    val sum = sortedArr[idx] + sortedArr[jdx]
                    answer.add(sum)
                }
            }
        }

        return answer.toSortedSet().toIntArray()
    }
}