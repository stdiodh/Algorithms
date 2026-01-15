package BOJ.queue

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }

    val n = int()
    val struct = IntArray(n) { int() }
    val deque = ArrayDeque<Int>()
    repeat(n){
        val num = int()
        deque.add(num)
    }

    val sb = StringBuilder()
    var t = int()
    val insert = IntArray(t){ int() }

    //마지막 큐 출력
    for (i in n - 1 downTo 0) {
        //삽입된만큼 출력하면 종료
        if (t == 0) break
        // 큐 일때
        if (struct[i] == 0) {
            sb.append("${deque[i]} ")
            t--
        }
    }

    //스택
    for (i in insert.indices){
        if(t == 0) break
        sb.append("${insert[i]} ")
        t--
    }

    print(sb)
}