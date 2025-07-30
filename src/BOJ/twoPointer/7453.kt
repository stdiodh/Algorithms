package BOJ.twoPointer

import java.io.StreamTokenizer

/**
 * 이 문제의 핵심은 ab를 더한 값을 담은 AB 배열과 cd를 더한 값을 담은 CD 배열을 투포인터로 0이 되는 값을 찾는 문제이다.
 * 하지만 여기서 0이 되는 경우를 브루드포스로 하나씩 +1을 해가면서 찾기에는 너무 시간 복잡도가 O(n^2) 만큼 커지기 때문에
 * 0이 되는 경우 left은 오른쪽으로 right는 왼쪽으로 같은 값이 있는 지 확인하여 그 값의 곱을 ans에 더하는 식으로
 * 시간 복잡도를 줄여가며 찾는게 핵심이다.
 * 1. a, b, c, d 배열을 받아준다.
 * 2. ab를 더한 배열과 cd를 더한 배열을 만들어 정렬해준다.
 * 3. 투포인터를 만들어 하나는 시작에서 시작해 왼쪽에서 하나는 끝에서 시작해 오른쪽으로 갈 수 있도록 조건을 걸어준다.
 * 4. 두 값을 더한 sum이 0보다 크면 음수에서 출발한 left를 오른쪽으로 이동해주고 0보다 작으면 양수에서 출발한 right를 왼쪽으로 이동해준다.
 * 5. 여기서 0에 도달했을 때는 주변에 같은 수가 AB와 CD 둘다 몇 개 있는지 확인(leftCnt, rightCnt에 저장)해준다.
 * 6. 그리고 그 두 수를 곱하면 경우의 수가 나오기 때문에 이 값을 ans에 저장해준다.
 * 7. 모두 돌았으면 ans를 출력해준다.
 */

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val aArr = IntArray(n) { 0 }
    val bArr = IntArray(n) { 0 }
    val cArr = IntArray(n) { 0 }
    val dArr = IntArray(n) { 0 }

    repeat(n){
        val a = i(); val b = i(); val c = i(); val d = i()
        aArr[it] = a; bArr[it] = b; cArr[it] = c; dArr[it] = d
    }

    val AB = IntArray(n*n) { 0 }
    val CD = IntArray(n*n) { 0 }

    var idx = 0
    repeat(n){i ->
        repeat(n){j ->
            AB[idx] = aArr[i] + bArr[j]
            CD[idx] = cArr[i] + dArr[j]
            idx++
        }
    }
    AB.sort()
    CD.sort()

    var left = 0; var right = n*n - 1
    var ans = 0L
    while(left < n*n && right >= 0){
        val sum = AB[left] + CD[right]
        if(sum < 0){
            left++
        } else if(sum > 0) {
            right--
        } else {
            var leftCnt = 1L; var rightCnt = 1L
            while(left+1 < n*n && (AB[left] == AB[left+1])){
                leftCnt++
                left++
            }
            while(right > 0 && (CD[right] == CD[right-1])){
                rightCnt++
                right--
            }
            ans += leftCnt * rightCnt
            left++
        }
    }
    print(ans)
}