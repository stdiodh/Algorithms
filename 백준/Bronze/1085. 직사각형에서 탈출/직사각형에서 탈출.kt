import java.io.StreamTokenizer
import kotlin.math.min

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int {
        nextToken()
        return nval.toInt()
    }


    val x = nextInt(); val y = nextInt(); val w = nextInt(); val h = nextInt()
    val xDistance = min(x, w-x)
    val yDistance = min(y, h-y)
    val result = min(xDistance,yDistance)
    println(result)
}