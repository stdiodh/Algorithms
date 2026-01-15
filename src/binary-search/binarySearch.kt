//package BOJ.BinarySearch
//
//import java.io.StreamTokenizer
//
//fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
//    fun nextInt() : Int { nextToken(); return nval.toInt() }
//
//    val n = nextInt()
//    val target = nextInt()
//
//    val arr = IntArray(n) { nextInt() }
//    val result = binarySearch(arr, target, 0, arr.size-1)
//    println("arr 안에 ${result}번째에 타겟이 있음.")
//}
//
//fun binarySearch(arr: IntArray, target: Int, left: Int, right: Int) : Int {
//    val mid = (left + right) / 2
//    return if (arr[mid] == target) {
//        return mid
//    } else if (arr[mid] < target) {
//        binarySearch(arr, target, mid+1,  right)
//    } else {
//        binarySearch(arr, target, left, mid-1)
//    }
//}