import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int {nextToken(); return nval.toInt()}

    val n = int()
    val list = mutableListOf<Int>()
    repeat(n){
        val num = int()
        list.add(num)
    }

    val min = list.min()
    val max = list.max()

    println(min * max)
}