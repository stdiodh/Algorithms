import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int {
        nextToken()
        return nval.toInt()
    }

    while(true){
        val n = nextInt(); val m = nextInt()
        if(n == 0 && m == 0){
            break
        }

        if (n % m == 0){
            println("multiple")
        } else if (m % n == 0){
            println("factor")
        } else {
            println("neither")
        }
    }
}