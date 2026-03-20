fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toCharArray().sortedDescending().joinToString("")
    println(n)
}
