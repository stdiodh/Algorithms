package `1week`

fun main(){
    val numbers = intArrayOf(45, 20, 35, 60, 55, 10, 90, 85, 25, 75)
    var max = numbers[0]

    for(x in numbers.indices){
        if(numbers[x] > max){
            max = numbers[x]
        }
    }

    print("배열의 최대값 : $max")
}