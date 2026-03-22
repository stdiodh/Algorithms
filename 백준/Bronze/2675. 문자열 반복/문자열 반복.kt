import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    repeat(sc.nextInt()){
        val n = sc.nextInt()
        val str = sc.next()
        var strRe = ""

        for (x in str.indices){
            repeat(n){
                strRe += str[x]
            }
        }
        println(strRe)
    }
}