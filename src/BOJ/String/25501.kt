package BOJ.String

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun string() : String { nextToken(); return sval }
    fun int() : Int { nextToken(); return nval.toInt() }

    val n = int()
    var cnt = 1
    val sb = StringBuilder()

    fun recursion(s : String,l : Int, r : Int) : Int {
        if(l >= r) return 1
        else if(s[l] != s[r]) return 0
        else {
            cnt++
            return recursion(s, l+1, r-1)
        }
    }

    fun isPalindrome(s : String) : Int{
        return recursion(s, 0, s.length-1)
    }

    repeat(n){
        val str = string()
        sb.appendLine("${isPalindrome(str)} $cnt")
        cnt = 1
    }
    print(sb)
}