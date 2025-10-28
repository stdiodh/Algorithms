import kotlin.math.max
import kotlin.math.min

class Solution {
    fun solution(dots: Array<IntArray>): Int {
        val (x1, y1) = dots[0]
        var maxX = x1
        var maxY = y1

        var minX = x1
        var minY = y1

        repeat(4){ i ->
            maxX = max(maxX, dots[i][0])
            maxY = max(maxY, dots[i][1])

            minX = min(minX, dots[i][0])
            minY = min(minY, dots[i][1])
        }

        return (maxX - minX) * (maxY - minY)
    }
}