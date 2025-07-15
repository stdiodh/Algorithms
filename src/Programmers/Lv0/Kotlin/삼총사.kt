package Programmers.Lv0.Kotlin

class 삼총사 {
    fun solution(number: IntArray): Int {
        var cnt = 0
        for(x in 0 until number.size - 2){
            for(y in x+1 until number.size - 1){
                for(z in y+1 until number.size){
                    if(number[x]+number[y]+number[z] == 0){
                        cnt++
                    }
                }
            }
        }
        return cnt
    }
}

fun main(){
    val n = 삼총사()
    println(n.solution(intArrayOf(-2,3,0,2,-5)))

    val number = intArrayOf(-2,3,0,2,-5)
    var cnt = 0

    for(x in 0 until number.size - 2){
        for(y in x+1 until number.size - 1){
            for(z in y+1 until number.size){
                println("$x $y $z")
                if(number[x]+number[y]+number[z] == 0){
                    cnt++
                }
            }
        }
    }
}