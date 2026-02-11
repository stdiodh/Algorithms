import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int {
        nextToken()
        return nval.toInt()
    }

    fun nextString() : String {
        nextToken()
        return sval
    }

    val n = nextInt(); val m = nextInt()
    val dd = HashSet<String>()
    val db = mutableListOf<String>()

    repeat(n){
        dd.add(nextString())
    }

    val sb = StringBuilder()
    repeat(m){
        val str = nextString()
        if(dd.contains(str)){
            db.add(str)
        }
    }
    db.sorted().forEach(){
        sb.appendLine(it)
    }

    println(db.size)
    println(sb)
}