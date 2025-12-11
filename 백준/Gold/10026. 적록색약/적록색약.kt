fun main(){
    val br = System.`in`.bufferedReader()
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)

    var RGBcnt = 0
    var RGcnt = 0

    val n = br.readLine().toInt()
    val graph1 = Array(n) { Array(n) {' '} }
    val graph2 = Array(n) { Array(n) {' '} }

    repeat(n){
        val input = br.readLine().toCharArray()
        for(i in 0..< n){
            graph1[it][i] = input[i]
            if(input[i] == 'G'){
                graph2[it][i] = 'R'
            } else {
                graph2[it][i] = input[i]
            }
        }
    }

    fun dfs(x:Int, y:Int, map:Array<Array<Char>>) : Boolean{
        if(map[x][y] == ' '){
            return false
        }

        val color = map[x][y]
        map[x][y] = ' '

        for(i in 0..< 4){
            val nx = dx[i] + x
            val ny = dy[i] + y

            if(nx < 0 || nx >= n || ny < 0 || ny >= n || color != map[nx][ny]){
                continue
            }

            dfs(nx, ny, map)
        }
        return true
    }

    repeat(n){x ->
        repeat(n){y ->
            if(dfs(x, y, graph1)){
                RGBcnt++
            }
            if(dfs(x, y, graph2)){
                RGcnt++
            }
        }
    }
    print("$RGBcnt $RGcnt")
}
