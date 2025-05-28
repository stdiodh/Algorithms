package BOJ.parsing

//fun main(){
//    val br = System.`in`.bufferedReader()
//
//    val (n, m) = br.readLine().split(" ").map { it.toInt() }
//    val notepad = mutableMapOf<String, Int>()
//
//    repeat(n){
//        val s = br.readLine()
//        notepad[s] = notepad.getOrDefault(s, 0) + 1
//    }
//
//    repeat(m){
//        val s = br.readLine().split(",")
//        for(i in 0 until s.size){
//            notepad.remove(s[i])
//        }
//        println(notepad.size)
//    }
//}

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val set = mutableSetOf<String>()
    repeat(n){
        set.add(readLine())
    }

    val result = StringBuilder()

    repeat(m){
        readLine().split(",").forEach {
            set.remove(it)
        }
        result.appendLine(set.size)
    }
    println(result)
}