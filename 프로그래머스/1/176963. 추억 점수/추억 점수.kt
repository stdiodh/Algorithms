class Solution {
    fun solution(names: Array<String>, yearning: IntArray, photos: Array<Array<String>>): IntArray {
        val answer = mutableListOf<Int>()
        val map = mutableMapOf<String, Int>()
        for(idx in names.indices){
            map[names[idx]] = yearning[idx]
        }

        for(idx in photos.indices) {
            var tmp = 0
            for(jdx in photos[idx].indices) {
                val name = photos[idx][jdx]
                if(map.contains(name)) {
                    tmp += map.getValue(name)
                }
            }
            answer.add(tmp)
        }

        return answer.toIntArray()
    }
}