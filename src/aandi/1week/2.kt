package aandi.`1week`

data class CommandInput(val n: String, val m: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val check = listOf("ADD", "MINUS", "MUL", "DIV")
    var cnt = 0

    fun input(): CommandInput? {
        val line = br.readLine() ?: return null
        val parts = line.split(" ")

        if (parts.size != 2) {
            if (line == "CLOSE") return CommandInput("CLOSE", 0)
            println("잘못된 입력 형식입니다. 예: ADD 10")
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

    while (true) {
        val result = input() ?: continue
        val n = result.n
        val m = result.m

        if (n == "CLOSE") {
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
