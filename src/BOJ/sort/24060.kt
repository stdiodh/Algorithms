package BOJ.sort

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun int(): Int { nextToken(); return nval.toInt() }

    val n = int()
    val K = int()
    val arr = IntArray(n) { int() }
    val sortedArr = IntArray(n)
    var count = 0
    var result = -1
    var found = false

    fun merge(arr: IntArray, start: Int, middle: Int, end: Int) {
        var i = start
        var j = middle + 1
        var k = start

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                sortedArr[k++] = arr[i++]
            } else {
                sortedArr[k++] = arr[j++]
            }
        }

        while (i <= middle) sortedArr[k++] = arr[i++]
        while (j <= end) sortedArr[k++] = arr[j++]

        for (t in start..end) {
            arr[t] = sortedArr[t]
            count++
            if (count == K) {
                result = arr[t]
                found = true
                return
            }
        }
    }

    fun mergeSort(arr: IntArray, start: Int, end: Int) {
        if (start < end && !found) {
            val middle = (start + end) / 2
            mergeSort(arr, start, middle)
            mergeSort(arr, middle + 1, end)
            merge(arr, start, middle, end)
        }
    }

    mergeSort(arr, 0, n - 1)
    print(result)
}
