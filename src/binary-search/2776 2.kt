package BOJ.BinarySearch

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val t = nextInt()
    val sb = StringBuilder()

    repeat(t){
        val n = nextInt()
        val arr1 = IntArray(n) { nextInt() }.sortedArray()
        val m = nextInt()
        val arr2 = IntArray(m) { nextInt() }

        for(i in arr2){
            if(binarySearch(arr1, i)){
                sb.appendLine(1)
            } else {
                sb.appendLine(0)
            }
        }
    }
    print(sb)
}

fun binarySearch(arr: IntArray, target: Int) : Boolean{
    var left = 0; var right = arr.size -1
    while (left <= right){
        val mid = (left+right) / 2
        if(arr[mid] == target){
            return true
        } else if(arr[mid] < target){
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return false
}