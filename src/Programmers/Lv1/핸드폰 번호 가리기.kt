package Programmers.Lv1

class `핸드폰번호가리기` {
    fun solution(phone_number: String): String {
        val behind = phone_number.takeLast(4)
        var printNum = ""
        for(i in 0 until phone_number.length - 4){
            printNum += "*"
        }
        printNum += behind
        return printNum
    }
}

fun main(){
    val n = 핸드폰번호가리기()
    println(n.solution("01033334444"))
}

