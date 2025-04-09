package Programmers.Lv1

class `문자열 내림차순으로 배치하기` {
    fun solution(s: String): String {
        return s.toCharArray().sortedArrayDescending().joinToString("")
    }
}