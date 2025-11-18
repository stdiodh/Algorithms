import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val m = nextInt()

    val graph = Array(n+1) { mutableListOf<Int>() }
    repeat(m){
        val a = nextInt(); val b = nextInt()
        graph[a].add(b)
        graph[b].add(a)
    }
    val visited = BooleanArray(n+1) { false }
    var cnt = 0

    fun dfs(n : Int){
        visited[n] = true
        for(i in graph[n]){
            if(!visited[i]){
                dfs(i)
                cnt++
            }
        }
    }

    dfs(1)
    print(cnt)
}