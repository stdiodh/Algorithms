package aandi.`4week`

fun main(){
    val a = 10
    val b = 20
    val sum = add(a, b)
    println(sum)
    println(System.identityHashCode(a))
}

fun add(a:Int, b:Int) : Int {
    return a + b
}
//
//data class User(val name: String)
//
//fun main() {
//    val u1 = User("DH")
//    val u2 = User("HD")
//}