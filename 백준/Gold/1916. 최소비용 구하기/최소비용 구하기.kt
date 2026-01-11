import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt(); val m = nextInt()
    val INF = 1_000_000_000
    val visited = BooleanArray(n+1) { false }
    val graph = Array(n+1) { mutableListOf<Pair<Int, Int>>() }
    val dist = IntArray(n+1) { INF }

    repeat(m){
        //도시, 버스, 비용
        val a = nextInt(); val b = nextInt(); val c = nextInt()
        graph[a].add(Pair(b, c))
    }
    //출발도시 끝도시
    val stCity = nextInt(); val edCity = nextInt()

    fun getMinDistNode() : Int {
        var minV = INF
        var idx = -1
        for(i in 1 .. n){
            if(dist[i] < minV && !visited[i]){
                minV = dist[i]
                idx = i
            }
        }
        return idx
    }

    fun dijkstra(start : Int){
        dist[start] = 0

        repeat(n){
            val now = getMinDistNode()
            if(now == -1) return
            visited[now] = true
            for ((nextCity, nextCost) in graph[now]) {
                val cost = dist[now] + nextCost
                if (cost < dist[nextCity]) {
                    dist[nextCity] = cost
                }
            }
        }
    }
    dijkstra(stCity)
    print(dist[edCity])
}