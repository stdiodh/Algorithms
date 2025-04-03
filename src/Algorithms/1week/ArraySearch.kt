package Algorithms.`1week`

fun main() {
    val array = intArrayOf(45, 20, 60, 35, 10, 55, 90, 85, 75, 25)
    val target = 85

    val rnt = searchArray(array, target)
    if(rnt != -1){
        println("찾는 값 $target 은 배열에 $rnt 번째에 있습니다.")
    } else {
        println("찾는 값 $target 은 배열에 없습니다.")
    }
}

fun searchArray(arr : IntArray, target: Int) : Int{
    for(x in arr.indices){
        if(arr[x] == target){
            return x
        }
    }
    return -1
}
