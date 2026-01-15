package BOJ.Greedy

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val meeting = mutableListOf<Pair<Int, Int>>()

    repeat(n){
        meeting.add(nextInt() to nextInt())
    }
    val sort = meeting.sortedBy { it.first }.sortedBy { it.second }

    var max = 0
    var endTime = 0

    for (i in sort){
        //정렬된 첫번째가 끝나는 시간이랑 같거나 끝나는 시간보다 크다면 끝나는 시간은 첫시간이 되고 max를 추가함
        if(i.first >= endTime){
            endTime = i.second
            max++
        }
    }
    print(max)
}