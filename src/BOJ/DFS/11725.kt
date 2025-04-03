package BOJ.DFS

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val graph = Array(n+1){ mutableListOf<Int>() }
    val parents = IntArray(n+1) { -1 }
    val visited = BooleanArray(n+1) { false }

    parents[1] = 1
    visited[1] = true

    repeat(n-1){
        val a = nextInt(); val b = nextInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    fun dfs(node: Int) {
        for(i in graph[node]){
            if(!visited[i]){
                visited[i] = true
                parents[i] = node
                dfs(i)
            }
        }
    }
    dfs(1)

    val sb = StringBuilder()
    for(i in 2..n){
        sb.appendLine(parents[i])
    }
    print(sb)
}