package BOJ.String

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }

    val n = int()
    val sb = StringBuilder()

    fun star (i : Int, j : Int, num : Int){
        if((i/num) % 3 == 1 && (j/num) % 3 == 1){
            sb.append(' ')
        } else {
            if(num / 3 == 0){
                sb.append('*')
            } else {
                star(i, j, num / 3)
            }
        }
    }

    for(i in 0 until n){
        for(j in 0 until n){
            star(i, j, n)
        }
        sb.appendLine()
    }
    print(sb)
}