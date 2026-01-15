package Programmers.Kotlin

class `약수의개수의덧셈` {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        for(i in left .. right){
            var div = 0
            for(j in 1 .. i){
                if(i % j == 0){
                    div++
                }
            }
            if(div % 2 == 0){
                answer += i
            } else {
                answer -= i
            }
        }
        return answer
    }
}
