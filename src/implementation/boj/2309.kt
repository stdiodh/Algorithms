import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt() : Int { nextToken(); return nval.toInt() }

    val dwarf = IntArray(9) { readInt() }.sortedArray()
    var sum = dwarf.sum()

    var a = 0; var b = 0

    for (i in 0 ..< dwarf.size){
        for(j in i+1 ..< dwarf.size) {
            if(sum - dwarf[i] - dwarf[j] == 100) {
                a = i
                b = j
                break
            }
        }
    }

    for(i in 0 ..< dwarf.size) {
        if(i!=a && i!=b) {
            println(dwarf[i])
        }
    }
}
