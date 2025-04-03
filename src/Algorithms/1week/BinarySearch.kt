package Algorithms.`1week`

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val arr1 = IntArray(n) { nextInt() }.sortedArray()

    val m = nextInt()
    val arr2 = IntArray(m) { nextInt() }

    val sb = StringBuilder()
    for(x in arr2){
        sb.appendLine(binarySearch(arr1, x))
    }
    print(sb)
}

fun binarySearch(arr: IntArray, target: Int): Int{
    var left = 0
    var right = arr.size - 1

    while(left <= right){
        val mid = (left+right) / 2
        if(target == arr[mid]){
            return 1
        }

        if(arr[mid] < target){
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return 0
}