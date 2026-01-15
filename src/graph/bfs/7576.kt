package BOJ.BFS

import java.io.StreamTokenizer
import java.util.LinkedList

/**
 * 이 문제는 n * m의 토마토 상자에 익지않는 토마토가 몇 일 만에 다 익는지를 구하는 문제이다.
 * 1. 입력을 받는다. (n: 상자의 가로 칸, m: 상자의 세로 칸, 상자안 토마토의 상태에 따른 2차원 배열)
 * 여기서 2차원 배열을 생각하면 m이 가로 칸이고 n이 세로 칸이다.
 * 2. 가까운 곳 상하좌우를 탐색해야하니 bfs를 이용하려고 한다.
 * 3. 만약 토마토의 상태를 받다 1을 발견하면 그 즉시 bfs를 돌아 상하좌우 중 0에 해당하는 부분에 이전의 좌표값에 들어았는 값을 더해주는 식으로
 * 그 자리의 토마토가 익는데 걸리는 시간을 구해준다.
 * 4. 그런데 여기서 이중 반복문으로 1인 칸에 bfs를 돌아 구해주기에는 정답 변수가 달라질 수 있기 때문에
 * 2차원 배열을 flatMap을 통해서 1차원 배열로 만들어 준 뒤 여기서 만약 0이 존재하면 도달할 수 없는 곳에 익지 않은 토마토가 있는 것이니 -1을
 * 아니라면 1차원 배열에 가장 큰 값을 가져오면 그것이 정답일테니 가져온다. (여기서 -1을 해주는 이유는 내가 있는 곳도 하루로 보니 제외해준다.)
 */

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i(); val m = i()
    val graph = Array(m) { IntArray(n) { 0 } }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    val queue = LinkedList<Pair<Int, Int>>()

    repeat(m){ x ->
        repeat(n){ y ->
            val num = i()
            if(num == 1){
                graph[x][y] = 1
                queue.add(Pair(x, y))
            } else if(num == -1){
                graph[x][y] = -1
            }
        }
    }

    while(queue.isNotEmpty()){
        val curr = queue.poll()
        val x = curr.first; val y = curr.second
        repeat(4){
            val nx = x + dx[it]; val ny = y + dy[it]
            if(nx < 0 || nx >= m || ny < 0 || ny >= n){
                return@repeat
            }
            if(graph[nx][ny] == 0){
                graph[nx][ny] += graph[x][y] + 1
                queue.add(Pair(nx, ny))
            }
        }
    }

    val rnt = graph.flatMap { it.toList() }
    if(rnt.contains(0)){
        print(-1)
    } else {
        print(rnt.max() - 1)
    }
}