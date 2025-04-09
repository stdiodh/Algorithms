package aandi.`1week`

data class CommandInput(val n: String, val m: Int)

var cnt = 0

fun main() {
    val check = listOf("ADD", "MINUS", "MUL", "DIV")

    while (true) {
        val (n, m) = input() ?: continue

        if (n == "CLOSE" && m == 0) {
            break
        }

        if (n in check) {
            calculate(m, n)
        } else {
            println("잘못된 입력입니다. 사용 가능한 명령어: ADD, MINUS, MUL, DIV")
        }
    }

    println(display(cnt))
}

fun input(): CommandInput? {
    val br = System.`in`.bufferedReader()
    val line = br.readLine() ?: return null
    val parts = line.split(" ")

    if (parts.size != 2) {
        if (line == "CLOSE") return CommandInput("CLOSE", 0)
        println("잘못된 입력 형식입니다. 예: ADD 10")
        return null
    }

    if (parts[0] == "CLOSE" && parts[1].toInt() != 0){
        println("CLOSE만 들어올 수 있습니다.")
        return null
    }

    val n = parts[0]
    val m = parts[1].toIntOrNull()

    if (m == null) {
        println("숫자를 올바르게 입력하세요.")
        return null
    }
    return CommandInput(n, m)
}

fun calculate(x: Int, input: String) {
    when (input) {
        "ADD" -> cnt += x
        "MINUS" -> cnt -= x
        "MUL" -> cnt *= x
        "DIV" -> if (x != 0) cnt /= x else println("0으로 나눌 수 없습니다.")
    }
}

fun display(cnt: Int): String {
    return when {
        cnt > 0 -> "+$cnt"
        cnt == 0 -> "0"
        else -> "-${-cnt}"
    }
}
