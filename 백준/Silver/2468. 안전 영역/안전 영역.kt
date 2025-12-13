import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt(): Int {
        nextToken(); return nval.toInt()
    }

    val n = nextInt()
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    val graph = Array(n) { IntArray(n) { nextInt() } }

    fun dfs(x: Int, y: Int, height: Int, visited: Array<BooleanArray>) {
        visited[x][y] = true
        for (i in 0 ..< 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 ..< n && ny in 0 ..< n && !visited[nx][ny] && graph[nx][ny] > height) {
                dfs(nx, ny, height, visited)
            }
        }
    }

    var maxSafeArea = 0
    val maxHeight = graph.maxOf { it.maxOrNull() ?: 0 }

    for (height in 0..maxHeight) {
        val visited = Array(n) { BooleanArray(n) { false } }
        var safeAreaCount = 0

        for (x in 0 ..< n) {
            for (y in 0 ..< n) {
                if (graph[x][y] > height && !visited[x][y]) {
                    safeAreaCount++
                    dfs(x, y, height, visited)
                }
            }
        }
        maxSafeArea = maxOf(maxSafeArea, safeAreaCount)
    }

    println(maxSafeArea)
}