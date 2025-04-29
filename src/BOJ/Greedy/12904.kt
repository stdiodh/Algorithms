package BOJ.Greedy

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun next() : String { nextToken(); return sval }

    //문자열의 뒤에 A를 추가한다.
    //문자열을 뒤집고 뒤에 B를 추가한다.

    val s = next()
    var t = next()

    while(true){
        //모든 연산이 끝났을 때 남아있는 t가 s와 같다면 같다고 정답출력
        if(s==t){
            print(1)
            break
        }

        //다르다면 틀린 것이니 0 출력 후 종료
        if(t.length < s.length){
            print(0)
            break
        }

        if(t.last() == 'A'){
            //t의 맨뒤가 a라면 무조건 a를 삭제
            t = t.dropLast(1)
        } else if (t.last() == 'B'){
            //t의 맨뒤가 b라면 뒤집고 b를 삭제
            t = t.dropLast(1).reversed()
        }
    }
}