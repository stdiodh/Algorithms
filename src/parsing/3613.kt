package BOJ.parsing

fun main() {
    val br = System.`in`.bufferedReader()

    val s = br.readLine()
    val sb = StringBuilder()

    val isJava = s.any { it.isUpperCase() }
    val isCpp = s.contains("_")

    // 에러 케이스 처리
    if (isJava && isCpp || s.startsWith("_") || s.endsWith("_") || s.contains("__")) {
        println("Error!")
        return
    }

    if (isJava) {
        // Java → C++
        for (x in s) {
            if (x.isUpperCase()) {
                sb.append('_')
                sb.append(x.lowercaseChar())
            } else {
                sb.append(x)
            }
        }
    } else if (isCpp) {
        // C++ → Java
        val parts = s.split("_")
        sb.append(parts[0])  // 첫 단어는 그대로
        for (i in 1 until parts.size) {
            if (parts[i].isEmpty()) {  // 이중 언더스코어가 있었거나, 빈 파트가 생긴 경우
                println("Error!")
                return
            }
            sb.append(parts[i].replaceFirstChar { it.uppercaseChar() })
        }
    } else {
        // 모두 소문자면 그대로 출력
        sb.append(s)
    }

    println(sb)
}
