package Programmers.Lv1

class `크기가작은부분문자열` {
    fun solution(t: String, p: String): Int {
        //t는 문자열 전체 p는 문자열 갯수(비교 숫자)
        var answer: String = ""
        var cnt = 0

        repeat(t.length - p.length + 1){i ->
            answer = t.substring(i, i+p.length)
            if(p.toLong() >= answer.toLong()){
                cnt++
            }
        }
        return cnt
    }
}

fun main(){
    val n = 크기가작은부분문자열()
    println(n.solution("3141592", "271"))
}