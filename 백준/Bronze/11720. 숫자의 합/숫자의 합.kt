fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val num = readLine().toCharArray()

    var result = 0

    repeat(n){
        result += num[it] - '0'
    }

    print(result)
}