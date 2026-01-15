package BOJ.BFS

/**
 * 문제의 핵심은 현재 구해야 하는 곳이 단지수와 단지에 속하는 집의 수를 오름차순으로 정렬해 출력하는 것이다.
 * 1. 입력을 받는다. (n * n 칸의 정사각형, 그래프는 공백없이 받으니 한줄로 받아 리스트 상태에서 한 개씩 가져올 때 '1'이라면 해당 칸을 1로 처리해줌.)
 * 2. 지도에서 집은 1로 아무것도 없는 곳은 0이기 때문에 x, y 2차원 반복을 돌며 1인 곳을 찾고 그곳에 좌우상하에 1인곳을 계속 이어가서 단지의 수를 구한다.
 * 3. 그리고 그 단지의 수를 구한 것을 배열안에 담아두고 배열의 사이즈는 단지수의 갯수가 된다.
 * 4. 먼저 단지의 수가 나와야 하니 배열의 크기를 출력하고 배열안의 값은 집의 수가 되는 데 이 때 오름차순으로 정렬해서 출력한다.
 */

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val graph = Array(n) { IntArray(n) { 0 } }
    val visited = Array(n) { BooleanArray(n) { false } }
    val dx = intArrayOf(1,-1,0,0)
    val dy = intArrayOf(0,0,1,-1)

    repeat(n){ x ->
        val line = readLine()
        repeat(n){ y ->
            if(line[y] == '1'){
                graph[x][y] = 1
            }
        }
    }

    fun bfs(x: Int, y:Int) : Int {
        var cnt = 1

        repeat(4){ i ->
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                return@repeat
            }

            if(graph[nx][ny] == 1 && !visited[nx][ny]){
                visited[nx][ny] = true
                cnt += bfs(nx,ny)
            }
        }
        return cnt
    }

    val areaArr = mutableListOf<Int>()

    repeat(n){x ->
        repeat(n){y ->
            if(!visited[x][y] && graph[x][y] == 1){
                visited[x][y] = true
                areaArr.add(bfs(x, y))
            }
        }
    }

    println(areaArr.size)
    areaArr.sort()
    areaArr.forEach { println(it) }
}