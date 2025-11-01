import java.io.StreamTokenizer
import kotlin.math.min


fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }
    fun nextString() : String { nextToken(); return sval }
    
    val n = nextInt(); val m = nextInt()

    val board = Array(n) {
        nextString()
    }
    var ans = n * m
    
    for (x in 0..<n-7){
        for (y in 0..<m-7){
            var w = 0
            var b = 0
            
            for (dx in x ..<x+8){
                for(dy in y ..<y+8){
                    if ((dx+dy) % 2 == 0){
                        if(board[dx][dy] == 'B'){
                            w += 1
                        } else {
                            b += 1
                        }
                    } else {
                        if (board[dx][dy] == 'W'){
                            w += 1
                        } else {
                            b += 1
                        }
                    }
                }
            }
            ans = min(ans, min(w, b))
        }
    }
    print(ans)
}