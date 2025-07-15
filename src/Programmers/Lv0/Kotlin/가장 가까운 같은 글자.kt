package Programmers.Lv0.Kotlin

class `가장가까운같은글자` {
    fun solution(s: String): IntArray {
        val result = IntArray(s.length) { -1 }
        val lastSeen = mutableMapOf<Char, Int>()

        for(i in s.indices){
            val ch = s[i]
            if(lastSeen.containsKey(ch)){
                result[i] = i - lastSeen[ch]!!
            }
            lastSeen[ch] = i
        }
        return result
    }
}

fun main(){
    val n = 가장가까운같은글자()
    println(n.solution("banana").toList())
}