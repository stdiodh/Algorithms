package aandi.`5week`

class Calculator {
    fun add(a: Int, b: Int) : Int {
        return a + b
    }
    fun add(a: Double, b: Double) : Double {
        return a + b
    }
    fun add(a: Int, b:Int, c:Int) : Int {
        return a + b + c
    }
}

fun main(){
    val calc = Calculator()
    val sum1 = calc.add(1,2)
    val sum2 = calc.add(1.1, 1.2)
    val sum3 = calc.add(1, 2, 3)
    println("$sum1 $sum2 $sum3") //3 2.3 6
}