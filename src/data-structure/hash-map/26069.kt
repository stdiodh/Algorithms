package BOJ.sort

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val set = HashSet<String>()
    set.add("ChongChong")

    repeat(t){
        val (a, b) = br.readLine().split(" ")

        if(set.contains(a)){
            set.add(b)
        }
        if(set.contains(b)){
            set.add(a)
        }
    }

    println(set.size)
}
