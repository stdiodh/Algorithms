import java.io.StreamTokenizer
import kotlin.math.min

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt(); val m = nextInt()
    val INF = 1_000_000_000
    val dist = Array(n+1) { IntArray(n+1) { INF } }

    for(i in 1..n){
        dist[i][i] = 0
    }

    repeat(m){
        val a = nextInt(); val b = nextInt()
        dist[a][b] = 1
        dist[b][a] = 1
    }

    repeat(n){k ->
        repeat(n){i ->
            repeat(n){j ->
                dist[i+1][j+1] = min(dist[i+1][j+1], dist[i+1][k+1] + dist[k+1][j+1])
            }
        }
    }

    var sum = INF
    var ans = 0
    for(i in 1..n){
        var cnt = 0
        for(j in 1 .. n){
            if(i == j) {
                continue
            }
            cnt += dist[i][j]
        }
        if(sum > cnt){
            sum = cnt
            ans = i
        }
    }
    print(ans)
}