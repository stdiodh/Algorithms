fun main(){
    val br = System.`in`.bufferedReader()

    val arr = Array(5) { Array(15) { ' ' } }
    val sb = StringBuilder()
    repeat(5){
        val input = br.readLine()

        for(x in input.indices){
            arr[it][x] = input[x]
        }
    }

    repeat(15){x ->
        repeat(5){y ->
            if(arr[y][x] != ' '){
                sb.append(arr[y][x])
            }
        }
    }
    print(sb)
}