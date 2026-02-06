import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun next() : String { nextToken(); return sval }
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt()
    val map = Array(201){ StringBuilder() }
    repeat(n){
        val age = nextInt(); val name = next()
        map[age].appendLine("$age $name")
    }

    val sb = StringBuilder()
    map.forEach {
        sb.append(it)
    }
    print(sb)
}