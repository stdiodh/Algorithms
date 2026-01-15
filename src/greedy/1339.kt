package BOJ.Greedy

import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun next() : String { nextToken(); return sval }
    fun nextInt() : Int { nextToken(); return nval.toInt() }
    val n = nextInt()  // 1. 단어 개수 입력
    val words = List(n) { next() }  // 2. 단어들을 리스트로 입력 받기
    val weightMap = mutableMapOf<Char, Int>()  // 3. 각 알파벳의 자리수 가중치를 저장할 map

    // 4. 단어들을 하나씩 보면서
    for (word in words) {
        var pow = 1  // 가장 오른쪽(1의 자리)부터 시작
        for (i in word.length - 1 downTo 0) {  // 오른쪽 -> 왼쪽으로 순회
            val c = word[i]
            // 해당 알파벳의 기존 가중치에 자리수 가중치 추가
            weightMap[c] = weightMap.getOrDefault(c, 0) + pow
            pow *= 10  // 왼쪽으로 갈수록 자리수는 10배 커짐
        }
    }

    // 5. 모든 알파벳을 가중치가 높은 순서로 정렬
    val sortedList = weightMap.entries.sortedByDescending { it.value }

    // 6. 9부터 차례로 큰 가중치를 가진 알파벳에 숫자를 배정
    var num = 9
    val charToNumber = mutableMapOf<Char, Int>()  // 알파벳 -> 숫자 매칭
    for ((char, _) in sortedList) {
        charToNumber[char] = num--
    }

    // 7. 단어를 숫자로 변환하고 전체 합 계산
    var total = 0
    for (word in words) {
        var temp = ""
        for (c in word) {
            temp += charToNumber[c]  // 알파벳을 대응되는 숫자로 변환
        }
        total += temp.toInt()  // 변환한 숫자를 더함
    }

    // 8. 정답 출력
    print(total)
}
