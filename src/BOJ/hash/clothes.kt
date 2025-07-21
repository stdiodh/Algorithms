package BOJ.hash

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 0
        val hash = mutableListOf<HashMap<String, String>>()

        for((name, wear) in clothes){
            hash.add(hashMapOf(wear to name))
        }

        println(hash)


        return answer
    }
}