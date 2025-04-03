package Algorithms.`2week`

fun main(){
    fun gcdRecursive(a : Int, b : Int) : Int {
        if(b == 0){
            return a
        }
        return gcdRecursive(b, a % b)
    }

    val num1 = 24
    val num2 = 14

    print("최대공약수 : ${gcdRecursive(num1, num2)}")
}