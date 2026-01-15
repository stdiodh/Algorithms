package BOJ.hashMap

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var cnt = 0
    val list = HashSet<String>()
    repeat(n){
        val str = br.readLine()
        if(str == "ENTER"){
            list.clear()
        } else {
            if(list.add(str)){
                cnt++
            }
        }
    }
    println(cnt)
}
