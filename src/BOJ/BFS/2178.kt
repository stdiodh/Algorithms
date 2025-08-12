package BOJ.BFS

import java.util.LinkedList

/**
 * 이 문제의 핵심은 그래프 탐색으로 0,0 부터 시작하여 1을 따라가여 미로를 찾은 다음
 * 출구에서 1을 찾아 최소 몇 칸을 지나 n,m 에 도착하는지를 알아내는 문제이다.
 * 1. 입력을 받아준다. (m: 가로, n: 세로, 그래프 크기만큼 정수 미로)
 * 2. 좌표 이동배열과 함께 bfs 로직을 만들어주는데 우리가 필요한 것은 최소 몇 칸을 지나야 하는지를 알아야 하기 때문에
 * 1을 따라 들어온 곳에 이전 값을 계속 더해주는 식으로 로직을 작성해준다.
 * 3. 그렇다면 n, m의 위치에 있는 값은 최소 1을 몇 칸 따라 왔는지 알 수 있기 때문에 출력을 해준다.
 * 이 때 좌표는 0,0 에서 부터 시작했으니 -1을 각각 해주어 출력한다.
 */

fun main() = with((System.`in`.bufferedReader())){
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n){ IntArray(m) { 0 } }
    val visited = Array(n) { BooleanArray(m) { false } }
    val dx = intArrayOf(1,-1,0,0)
    val dy = intArrayOf(0,0,1,-1)

    repeat(n){x ->
        val line = readLine().map { it }
        repeat(m){ y ->
            if(line[y] == '1'){
                graph[x][y] = 1
            }
        }
    }

    fun bfs(x: Int, y: Int) {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(x, y))
        while (queue.isNotEmpty()){
            val curr = queue.poll()
            val x = curr.first; val y = curr.second
            repeat(4){
                val nx = x + dx[it]
                val ny = y + dy[it]

                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    return@repeat
                }

                if(!visited[nx][ny] && graph[nx][ny] == 1){
                    visited[nx][ny] = true
                    graph[nx][ny] += graph[x][y]
                    queue.add(Pair(nx, ny))
                }
            }
        }
    }

    bfs(0, 0)
    print(graph[n-1][m-1])
}