fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toCharArray()
    n.sortDescending()

    // 0이 없거나, 3의 배수가 아닌 경우
    if ('0' !in n || n.sumOf { it.digitToInt() } % 3 != 0) {
        print(-1)
    } else {
        print(n.joinToString(""))
    }
}