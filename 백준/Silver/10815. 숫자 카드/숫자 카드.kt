import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val hand = IntArray(n) { nextInt() }
    hand.sort()
    val m = nextInt()
    val card = IntArray(m) { nextInt() }

    val ans = IntArray(m) { 0 }

    for(x in card.indices){
        ans[x] = binarySearch(hand, card[x], n)
    }

    println(ans.joinToString(" "))
}

fun binarySearch(arr : IntArray, target : Int, size : Int) : Int {
    var start = 0; var end = (size - 1)
    var key = 0
    while (start <= end){
        val mid = (start + end) / 2
        if(target == arr[mid]){
            key = 1
            break
        } else if (arr[mid] < target){
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return key
}
