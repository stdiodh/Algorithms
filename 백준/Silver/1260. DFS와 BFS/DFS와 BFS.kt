import java.io.StreamTokenizer
import java.util.LinkedList
import java.util.Queue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt(): Int { nextToken(); return nval.toInt() }

    // 입력 처리
    val n = nextInt() // 정점의 개수
    val m = nextInt() // 간선의 개수
    val v = nextInt() // 시작 정점

    // 그래프 초기화
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val x = nextInt()
        val y = nextInt()
        graph[x].add(y)
        graph[y].add(x)
    }

    // 그래프의 각 리스트를 정렬 (노드 번호가 작은 순서로 탐색하기 위함)
    graph.forEach { it.sort() }

    // 방문 배열 초기화
    val dfsVisited = BooleanArray(n + 1) { false }
    val bfsVisited = BooleanArray(n + 1) { false }

    val dfsAns = StringBuilder()
    val bfsAns = StringBuilder()

    // DFS 함수 정의
    fun dfs(node: Int) {
        dfsVisited[node] = true
        dfsAns.append("$node ")

        for (n in graph[node]) {
            if (!dfsVisited[n]) {
                dfs(n)
            }
        }
    }

    fun bfs(start: Int) {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)
        bfsVisited[start] = true

        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            bfsAns.append("$curr ")

            for (n in graph[curr]) {
                if (!bfsVisited[n]) {
                    bfsVisited[n] = true
                    queue.add(n)
                }
            }
        }
    }

    // 탐색 실행
    dfs(v) // DFS 실행
    bfs(v) // BFS 실행

    // 결과 출력
    println(dfsAns)
    println(bfsAns)
}