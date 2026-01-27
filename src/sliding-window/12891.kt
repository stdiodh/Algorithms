import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun readInt() : Int { nextToken(); return nval.toInt() }
    fun readString() : String { nextToken(); return sval }

    val s = readInt(); val p = readInt()
    val str = readString().toCharArray()
    val myAcgt = IntArray(4) { 0 }
    val checkAcgt = IntArray(4) { readInt() }
    var checkSecret = 0
    var result = 0

    repeat(4) {
        if(checkAcgt[it] == 0) checkSecret++
    }

    fun add(c : Char) {
        when(c) {
            'A' -> {
                myAcgt[0]++
                if(myAcgt[0] == checkAcgt[0]) checkSecret++
            }
            'C' -> {
                myAcgt[1]++
                if(myAcgt[1] == checkAcgt[1]) checkSecret++
            }
            'G' -> {
                myAcgt[2]++
                if(myAcgt[2] == checkAcgt[2]) checkSecret++
            }
            'T' -> {
                myAcgt[3]++
                if(myAcgt[3] == checkAcgt[3]) checkSecret++
            }
        }
    }

    fun remove(c : Char) {
        when(c) {
            'A' -> {
                if(myAcgt[0] == checkAcgt[0]) checkSecret--
                myAcgt[0]--
            }
            'C' -> {
                if(myAcgt[1] == checkAcgt[1]) checkSecret--
                myAcgt[1]--
            }
            'G' -> {
                if(myAcgt[2] == checkAcgt[2]) checkSecret--
                myAcgt[2]--
            }
            'T' -> {
                if(myAcgt[3] == checkAcgt[3]) checkSecret--
                myAcgt[3]--
            }
        }
    }

    for(i in 0 ..< p) {
        //초기 부분 문자열 세팅
        add(str[i])
    }
    if(checkSecret == 4) result++

    //슬라이딩 윈도우
    for(i in p ..< s) {
        val j = i - p
        add(str[i])
        remove(str[j])

        if(checkSecret == 4) result++
    }

    print(result)
}
