import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val a = nextInt(); var b = nextInt()
    var cnt = 1

    while(a != b){
        if(a > b){
            break
        }

        //10으로 나눴을 때 나머지가 1이라면 오른쪽에 1 삽입
        if(b % 10 == 1){
            b /= 10
            cnt++
        } else if (b % 2 == 0){
            //10으로 나눌 수 없으면 2로 나눔
            b /= 2
            cnt ++
        } else {
            break
        }
    }

    if(a == b){
        print(cnt)
    } else {
        print(-1)
    }
}