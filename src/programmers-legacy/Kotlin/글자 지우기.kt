package Programmers.Kotlin

class `글자지우기` {
    fun solution(my_string: String, indices: IntArray): String {
        return my_string.filterIndexed { index, _ -> index !in indices }
    }
}

fun main(){
    val s = 글자지우기()
    val my_string = "apporoograpemmemprs"
    val indices = intArrayOf(1, 16, 6, 15, 0, 10, 11, 3)
    println(s.solution(my_string, indices))
}