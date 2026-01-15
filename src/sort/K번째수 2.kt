package Programmers.sort

class K번째수 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()

        repeat(commands.size){
            var list = mutableListOf<Int>()
            for(i in commands[it][0] - 1 until commands[it][1]){
                list.add(array[i])
            }
            list = list.sorted().toMutableList()
            answer += list[commands[it][2] - 1]
        }

        return answer
    }
}


fun main(){
    val f = K번째수()
    println(f.solution(intArrayOf(1, 5, 2, 6, 3, 7, 4), arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))))
}