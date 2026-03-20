fun main() {
    val br = System.`in`.bufferedReader()
    val num = br.readLine().toCharArray()

    for(i in 0 .. num.size - 1) {
        for(j in i until num.size) {
            if(num[i] < num[j]) {
                val temp = num[i]
                num[i] = num[j]
                num[j] = temp
            }
        }
    }

    print(num)
}
