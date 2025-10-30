import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun i() : Int { nextToken(); return nval.toInt() }

    var n = i()

    if(n == 1){
        print("")
        return@with
    }

    for(i in 2 .. n) {
        if(n % i == 0){
            while(n % i == 0){
                n /= i
                println(i)
            }
        }
    }
}