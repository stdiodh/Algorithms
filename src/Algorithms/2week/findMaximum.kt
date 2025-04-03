package Algorithms.`2week`

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int {
        nextToken()
        return nval.toInt()
    }
    fun findByMaximum(intArray: IntArray) : Int{
        var max = intArray[0]
        repeat(intArray.size){
            if(intArray[it] > max){
                max = intArray[it]
            }
        }
        return max
    }

    val n = nextInt()
    val intArray = IntArray(n){ nextInt() }
    val max = findByMaximum(intArray)

    print("최다값 : $max")
}