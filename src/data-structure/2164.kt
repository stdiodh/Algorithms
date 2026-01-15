package BOJ.Structure

import java.io.StreamTokenizer
import java.util.LinkedList
import java.util.Queue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val queue: Queue<Int> = LinkedList()

    repeat(n){
        queue.add(it+1)
    }

    while(queue.size > 1){
        //첫 값 삭제
        queue.poll()
        //다음 값 반환
        val next = queue.poll()
        //마지막에 값 추가
        queue.add(next)
    }
    print(queue.peek())
}