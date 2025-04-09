package Programmers.Lv1

class `콜라츠추측` {
    fun solution(num: Int): Int {
        var answer = 0
        var a = num.toLong()

        while(a != 1L){
            if(a % 2 == 0L) a /= 2
            else a = (a * 3) + 1
            answer++

            if(answer == 500){
                answer = -1
                break
            }
        }

        return answer
    }
}

fun main(){
    val n = 콜라츠추측()
    println(n.solution(1))
}