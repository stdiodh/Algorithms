class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        repeat(commands.size) { i ->
            val start = commands[i][0]; val last = commands[i][1]; val target = commands[i][2]
            //1. i부터 j까지 슬라이싱
            //2. 슬라이싱을 정렬한다.
            val sortArray = array.sliceArray(start-1..last-1).sorted()
            //3. k번째 숫자를 가져온다.
            val answerNumber = sortArray[target-1]
            //3. 정렬된 슬라이싱을 정답 배열에 담음
            answer.add(answerNumber)
        }
        
        //4. 모든 commands를 완료한 정답 배열을 출력
        return answer.toIntArray()
    }
}