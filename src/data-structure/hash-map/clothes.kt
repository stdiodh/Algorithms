package Programmers.hash

class Clothes {
    fun solution(clothes: Array<Array<String>>): Int {
        /**
         * groupBy로 카테고리별로 묶기
         * 이후 총 갯수와 values의 size + 1을 더한 것에 곱이 Com 일테니
         * 거기에 1을 빼줘서 (최소 하루의 의상을 입지 않음으로)
         * 값을 출력해준다.
         */
        return clothes.groupBy { it[1] }.values.fold(1) { total, values -> total * (values.size + 1)} - 1
    }
}