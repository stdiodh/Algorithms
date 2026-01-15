package BOJ.Implementation

fun main() {
    val br = System.`in`.bufferedReader()
    val target = br.readLine().replace('9', '6').map { it.code - 48 }.sorted().toMutableList()
    var cnt = 0

    while(target.isNotEmpty()){
        val arr = listOf(0, 1, 2, 3, 4, 5, 6, 6, 7, 8)
        for(x in arr.indices){
            target.remove(arr[x])
        }
        cnt++
    }
    println(cnt)
}