package programmers.Lv0

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt(); val m = nextInt()
    val arr = IntArray(m)
    val check = BooleanArray(n)
    val sb = StringBuilder()

    fun dfs(row : Int){
        if(row == m){
            arr.forEach {
                sb.append("$it ")
            }
            sb.append('\n')
            return
        }

        for(i in 0 ..< n){
            if(!check[i]){
                check[i] = true
                arr[row] = i + 1
                dfs(row + 1)
                check[i] = false
            }
        }
    }
    dfs(0)

    print(sb)
}