class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        val hall = mutableListOf<Int>()
        val answer = mutableListOf<Int>()

        for (s in score) {
            hall.add(s)
            hall.sortDescending()

            if (hall.size > k) {
                hall.removeAt(hall.lastIndex)
            }

            answer.add(hall.last())
        }

        return answer.toIntArray()
    }
}