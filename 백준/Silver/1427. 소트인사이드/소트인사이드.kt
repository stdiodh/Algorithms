fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toCharArray().map { it.code - 48 }.sortedDescending()
    println(n.joinToString(""))
}