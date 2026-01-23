fun main() {
    val numbers = BooleanArray(10001) { false }
    val sb = StringBuilder()


    for(i in 1 .. 10000) {
        val generated = generateNextNumber(i)
        if (generated <= 10000) {
            numbers[generated] = true
        }
    }

    for(i in 1 .. 10000){
        if(!numbers[i]) {
            sb.appendLine(i)
        }
    }

    print(sb)
}

fun generateNextNumber(number: Int) : Int {
    var sum = number
    var current = number

    while (current > 0) {
        sum += current % 10
        current /= 10
    }
    return sum
}