import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun next() : String { nextToken(); return sval }

    val a = next(); val b = next()
    var ans = a.length

    for(x in 0..(b.length - a.length)){
        var tmp = 0

        for(y in a.indices){
            if(a[y] != b[y+x]){
                tmp++
            }
        }
        if(ans > tmp){
            ans = tmp
        }
    }
    println(ans)
}