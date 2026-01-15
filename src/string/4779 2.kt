package BOJ.String

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)

    fun cantor(str: String) : String {
        return str + " ".repeat(str.length) + str
    }

    while(sc.hasNext()){
        val n = sc.nextInt()
        var result = "-"

        repeat(n){
            result = cantor(result)
        }

        println(result)
    }
}