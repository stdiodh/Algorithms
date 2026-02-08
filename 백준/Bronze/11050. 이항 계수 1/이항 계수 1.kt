import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun int() : Int { nextToken(); return nval.toInt() }

    val n = int(); val k = int()

    var molecule = 1
    for(i in n downTo 1){
        molecule *= i
    }

    var denominator1 = 1
    var denominator2 = 1
    for(i in n-k downTo 1){
        denominator1 *= i
    }
    for(i in k downTo 1){
        denominator2 *= i
    }

    print(molecule / (denominator1 * denominator2))
}