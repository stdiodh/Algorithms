class Solution {
    fun solution(answers: IntArray): IntArray {
        val supo1 = intArrayOf(1, 2, 3, 4, 5)
        val supo2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val supo3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        val cnt = intArrayOf(0, 0, 0)

        for (i in answers.indices) {
            if (answers[i] == supo1[i % supo1.size]) cnt[0]++
            if (answers[i] == supo2[i % supo2.size]) cnt[1]++
            if (answers[i] == supo3[i % supo3.size]) cnt[2]++
        }

        val maxVal = cnt.maxOrNull()

        val result = mutableListOf<Int>()
        for (i in cnt.indices) {
            if (cnt[i] == maxVal) {
                result.add(i + 1)
            }
        }

        return result.toIntArray()
    }
}