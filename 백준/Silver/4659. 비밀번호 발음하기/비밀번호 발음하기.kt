import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextString() : String { nextToken(); return sval }

    val sb = StringBuilder()
    val regex = run{
        val onlyConsonant = "^[^aeiou]+$"
        val threeConsonant = ".*[^aeiou]{3,}.*"
        val threeVowel = ".*[aeiou]{3,}.*"
        val repetitive = ".*([^eo])\\1.*"

        "${onlyConsonant}|${threeConsonant}|${threeVowel}|${repetitive}".toRegex()
    }
    while (true) {
        val str = nextString()
        if(str == "end") break
        sb.append('<').append(str)
        if(str.matches(regex)){
            sb.appendLine("> is not acceptable.")
        }else{
            sb.appendLine("> is acceptable.")
        }
    }
    print(sb)
}