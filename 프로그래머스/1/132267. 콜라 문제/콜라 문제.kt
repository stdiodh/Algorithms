class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var coke = n

        while(coke >= a) {
            answer += coke / a * b
            coke = (coke / a * b) + (coke % a)
        }

        return answer
    }
}