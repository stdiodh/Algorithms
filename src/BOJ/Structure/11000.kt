package BOJ.Structure

import java.io.StreamTokenizer
import java.util.PriorityQueue

data class Study(
    val start: Int,
    val end: Int
)
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val list = ArrayList<Study>()
    val room = PriorityQueue<Int>()

    for(i in 0 until n){
        list.add(Study(nextInt(), nextInt()))
    }

    list.sortBy { it.start }

    for(i in 0 until n){
        if(i == 0){
            room.add(list[i].end)
        } else {
            if(room.peek() <= list[i].start){
                room.poll()
                room.add(list[i].end)
            } else {
                room.add(list[i].end)
            }
        }
    }
    print(room.size)
}