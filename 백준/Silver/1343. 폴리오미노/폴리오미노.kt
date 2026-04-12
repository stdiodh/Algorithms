fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val line = br.readLine()
    var str = StringBuilder()
    var count = 0
    for (i in 0 .. line.count()) {
        if (i == line.count() || line[i] == '.') {
            if (count % 2 == 1) {
                str = StringBuilder()
                str.append(-1)
                break
            }

            while (count - 4 >= 0) {
                str.append("AAAA")
                count -= 4
            }
            while (count - 2 >= 0) {
                str.append("BB")
                count -= 2
            }
            if (i < line.count()) {
                str.append(".")
            }
            count = 0
        } else {
            count += 1
        }
    }
    bw.write(str.toString())
    br.close()
    bw.flush()
    bw.close()
}