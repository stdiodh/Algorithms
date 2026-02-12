import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val t = nextInt()
    val graph = Array(100){ BooleanArray(100) { false } }
    repeat(t){
        val x = nextInt(); val y = nextInt()
        for(i in x ..< x+10){
            for(j in y ..< y+10){
                graph[i][j] = true
            }
        }
    }
    var ans = 0
    repeat(100){x ->
        repeat(100){y ->
            if(graph[x][y]){
                ans++
            }
        }
    }
    print(ans)
}