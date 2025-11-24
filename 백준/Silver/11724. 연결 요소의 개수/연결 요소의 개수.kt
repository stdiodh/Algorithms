import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt(); val m = nextInt()
    val graph = Array(n+1) { mutableListOf<Int>() }

    repeat(m){
        val a = nextInt(); val b = nextInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    val visited = BooleanArray(n+1) { false }

    fun dfs(node : Int){
        visited[node] = true
        for(i in graph[node]){
            if(!visited[i]){
                dfs(i)
            }
        }
    }

    var cnt = 0
    for(i in 1..n){
        if(!visited[i]){
            dfs(i)
            cnt++
        }
    }
    print(cnt)
}