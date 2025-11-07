import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int {
        nextToken()
        return nval.toInt()
    }

    //줄의 배열 갯수 N, 합을 구해야 하는 횟수 M
    val n = nextInt(); val m = nextInt()

    val pSum = IntArray(n+1) {
        0
    }

    repeat(n){
        pSum[it + 1] = pSum[it] + nextInt()
    }

    val answer = StringBuilder()
    repeat(m){
        //i번째 부터 j번째 까지의 누접합을 구함
        val i = nextInt(); val j = nextInt()


        answer.appendLine(pSum[j] - pSum[i-1])
    }

    println(answer)
}