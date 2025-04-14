package Programmers.Lv1

class `이상한문자만들기` {
    fun solution(s: String): String {
        return s.split(" ").joinToString(" ") {
            it.mapIndexed { index, c ->
                if (index % 2 == 0) c.uppercaseChar() else c.lowercaseChar()
            }.joinToString("")
        }
    }
}


fun main(){
    val n = 이상한문자만들기()
    println(n.solution("  abc de  fghi   "))
}
