package BOJ.BinarySearch

import java.io.StreamTokenizer

/**
 * 이 문제는 타겟 숫자가 카드 배열에 몇 개 있는지 확인하는 문제이다.
 * 1. 입력을 받는다. (n: 카드 배열의 크기, n개 만큼의 카드 배열안의 값, m: 찾을 숫자의 배열 크기, m 찾을 배열의 숫자)
 * 여기서 입력의 크기가 매우 크기 때문에 탐색 시간을 고려하면 이진탐색을 해야한다.
 * 그리고 이진탐색을 한다고 한들 위치를 찾고 .count() 와 같은 탐색은 배열을 전체 순회하므로 O(n^2)의 시간이 걸린다.
 * 때문에 아이디어는 카드 배열을 정렬한 뒤에 번호에 해당하는 첫 인덱스와 마지막 인덱스를 찾아 두 개를 빼면 값이 나오는 것을 이용할 것이다.
 * 2. 이진 탐색을 두 개 돌리는데 하나는 숫자가 존재하면 그 인덱스를 바로 출력하는 lower 이진탐색과
 * 그 인덱스 발견시 그 이외 target이 같을 때마다 mid+1을 해주어 끝 인덱스가 무엇인지를 알아내는 upper 이진탐색을 두 개 만들어준다.
 * 숫자가 별견되지 않으면 mid를 출력한다.
 * 3. 두 개의 이진탐색을 구한 뒤 upper(발견된 마지막 인덱스) - lower(발견된 첫 인덱스)를 빼주어 출력해준다.
 */

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun i() : Int { nextToken(); return nval.toInt() }

    val n = i()
    val numArr = IntArray(n) { i() }.sortedArray()

    val m = i()
    val targetArr = IntArray(m) { i() }

    fun lowerBinarySearch(arr: IntArray, target: Int): Int {
        var start = 0
        var end = n
        while(start < end){
            val mid = (start + end) / 2
            if(arr[mid] < target) start = mid + 1
            else end = mid
        }
        return start
    }

    fun upperBinarySearch(arr: IntArray, target: Int) : Int {
        var start = 0
        var end = n
        while(start < end){
            val mid = (start + end) / 2
            if(arr[mid] <= target) start = mid + 1
            else end = mid
        }
        return start
    }

    val sb = StringBuilder()

    repeat(m){
        val lower = lowerBinarySearch(numArr, targetArr[it])
        val upper = upperBinarySearch(numArr, targetArr[it])
        sb.append("${upper - lower} ")
    }
    print(sb)

}