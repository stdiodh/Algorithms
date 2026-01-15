package BOJ.Implementation

// 무게 x, 키 y
// (x, y) (p, q) 라고 할 때 x > p 그리고 y > q 일때 A보다 B가 덩치가 큼
// 그런데 x > p y < q 일 시 서로 체급은 같다. 그래서 같은 등급임.
// 첫 번째 사람의 체급이 두 번째 사람 체급보다 크려면 키랑 몸무게가 전부다 커야함

fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { Pair(0, 0) }

    repeat(n){ i ->
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        arr[i] = Pair(x, y)
    }

    for(x in 0 until n){
        var rank = 1
        for(y in 0 until n){
            if(x == y){
                continue
            }

            //다음 사람이 키와 무게가 적다면 rank를 1 증가한다.
            if(arr[x].first < arr[y].first && arr[x].second < arr[y].second){
                rank++
            }
        }
        print("$rank ")
    }
}