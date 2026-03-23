import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun readInt(): Int {
        nextToken(); return nval.toInt()
    }

    fun readString(): String {
        nextToken(); return sval
    }

    fun recursion(s : CharArray, l : Int, r : Int, c : Int) : Pair<Int, Int> {
        var cnt = c
        if(l >= r) {
            return Pair(1, cnt)
        } else if (s[l] != s[r]) {
            return Pair(0, cnt)
        } else {
            cnt+=1
            return recursion(s, l+1, r-1, cnt)
        }
    }

    fun isPalindrome(s : CharArray): Pair<Int, Int> {
        return recursion(s, 0, s.size - 1, 1)
    }

    val n = readInt()
    val sb = StringBuilder()

    repeat(n) {
        val str = readString().toCharArray()

        val result = isPalindrome(str)
        sb.appendLine("${result.first} ${result.second}")
    }

    print(sb)
}