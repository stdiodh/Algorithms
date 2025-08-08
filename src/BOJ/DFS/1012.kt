package BOJ.DFS

//import java.io.StreamTokenizer
//
//fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
//    fun i() : Int { nextToken(); return nval.toInt() }
//
//    val t = i()
//    val dx = intArrayOf(1,-1,0,0)
//    val dy = intArrayOf(0,0,1,-1)
//    repeat(t){
//        val m = i(); val n = i(); val k = i()
//        val arr = Array(n) { IntArray(m) { 0 } }
//        val visited = Array(n) { BooleanArray(m) { false } }
//        repeat(k){
//            val x = i(); val y = i()
//            arr[y][x] = 1
//        }
//
//        fun dfs(x: Int, y:Int) : Unit{
//            var nx = x
//            var ny = y
//            arr[x][y] = 0
//            visited[x][y] = true
//
//            repeat(4){
//                nx = x + dx[it]
//                ny = y + dy[it]
//
//                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
//                    return@repeat
//                }
//
//                if(!visited[nx][ny] && arr[nx][ny] == 1){
//                    dfs(nx, ny)
//                }
//            }
//        }
//
//        var ans = 0
//        repeat(n){ x->
//            repeat(m){ y->
//                if(arr[x][y] == 1 && !visited[x][y]){
//                    ans++
//                    dfs(x, y)
//                }
//            }
//        }
//
//        print(ans)
//    }
//}

import java.io.StreamTokenizer
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val t = i()
    val dx = intArrayOf(1,-1,0,0)
    val dy = intArrayOf(0,0,1,-1)
    repeat(t) {
        val m = i();
        val n = i();
        val k = i()
        val arr = Array(n) { IntArray(m) { 0 } }
        val visited = Array(n) { BooleanArray(m) { false } }

        repeat(k) {
            val x = i();
            val y = i()
            arr[y][x] = 1
        }

        fun bfs(x: Int, y:Int){
            val queue = LinkedList<Pair<Int, Int>>()
            visited[x][y] = true

            queue.add(Pair(x, y))
            while(queue.isNotEmpty()){
                val curr = queue.pop()
                val x = curr.first; val y = curr.second
                for(i in 0..3){
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if(nx > 0 || nx <= n || ny > 0 || ny <= m){
                        continue
                    }

                    if(arr[nx][ny] == 1 && !visited[nx][ny]){
                        arr[nx][ny] = 0
                        visited[nx][ny] = true
                        queue.add(Pair(nx, ny))
                    }
                }
            }
        }

        var ans = 0
        repeat(n){ x->
            repeat(m){ y->
                if(arr[x][y] == 1 && !visited[x][y]){
                    ans++
                    bfs(x, y)
                }
            }
        }

        print(ans)
    }
}