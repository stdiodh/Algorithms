package BOJ.parsing

fun main() = with(System.`in`.bufferedReader()){
    val t = readLine().toInt()

    repeat(t){
        val input = readLine().split(" ")
        val soundList = ArrayList<String>()
        val sb = StringBuilder()
        while(true) {
            val line = readLine().split(" ")
            if (line[0] == "what") {
                break
            }
            soundList.add(line[2])
        }
        for (x in input) {
            if (!soundList.contains(x)) {
                sb.append("$x ")
            }
        }
        print(sb)
    }
}

//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//import java.util.*
//
//fun main(args: Array<String>) {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val bw = BufferedWriter(OutputStreamWriter(System.out))
//    val test = br.readLine().toInt()
//
//    for(t in 0 until test) {
//        val queue = LinkedList<String>()
//        val str = br.readLine().split(' ')
//        val soundList = ArrayList<String>()
//
//        while(true) {
//            val sound = br.readLine()
//            if(sound.equals("what does the fox say?")) break
//            soundList.add(sound.split(' ')[2])
//        }
//
//        for(s in str) {
//            if(soundList.contains(s)) continue
//            bw.write("$s ")
//        }
//        bw.write("\n")
//    }
//    bw.flush()
//}