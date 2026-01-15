import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    for(i in n .. 1) {
        repeat(i){
            print("*")
        }
        println()
    }
}
