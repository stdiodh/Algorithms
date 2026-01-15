package BOJ.Greedy

fun main() {
    val br = System.`in`.bufferedReader()

    val (n,m) = br.readLine().split(" ").map{it.toInt()}

    val arr1 = Array(n) { IntArray(m) { 0 } }
    val arr2 = Array(n) { IntArray(m) { 0 } }

    repeat(n){
        val line = br.readLine().toCharArray()
        for(i in line.indices){
            arr1[it][i] = line[i].code - 48
        }
    }

    repeat(n){
        val line = br.readLine().toCharArray()
        for(i in line.indices){
            arr2[it][i] = line[i].code - 48
        }
    }

    //검사하는 것을 만들어야함
    var cnt = 0
    for(i in 0 until n - 2){
        for(j in 0 until m - 2){
            if(arr1[i][j] != arr2[i][j]){
                cnt++
                for(r in i until i + 3){
                    for(c in j until j + 3){
                        arr1[r][c] = if(arr1[r][c] == 1) 0 else 1
                    }
                }
            }
        }
    }

    for(i in 0 until  n){
        for(j in 0 until m){
            if(arr1[i][j] != arr2[i][j]){
                print(-1)
                return
            }
        }
    }
    print(cnt)
}