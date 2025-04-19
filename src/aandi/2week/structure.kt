package aandi.`2week`

//import java.util.LinkedList
//import java.util.Queue

//import java.util.LinkedList
//
//fun main() {
//    val list = LinkedList<String>()
//    list.add("동현")
//    list.add("상욱")
//    list.add("준호")
//
//    for (name in list) {
//        val address = System.identityHashCode(name).toString(16) // 16진수로 보기 좋게
//        println("$name -> 주소 유사 값: 0x$address")
//    }
//}
// 동현 -> 주소 유사 값: 0x34a245ab
// 상욱 -> 주소 유사 값: 0x7c3df479
// 준호 -> 주소 유사 값: 0x7106e68e

//fun main(){
//    val stack = Stack<String>()
//    stack.add("동현")
//    stack.add("상욱")
//    stack.add("준호")
//
//    stack.pop() // 가장 마지막 요소 제거
//    println(stack) // [동현, 상욱]
//}

//fun main() {
//    val queue : Queue<String> = LinkedList<String>()
//    queue.add("동현")
//    queue.add("상욱")
//    queue.add("준호")
//
//    println("현재 큐 : $queue") // 현재 큐 : [동현, 상욱, 준호]
//
//    val first = queue.poll()
//    println("꺼낸 값 : $first") // 꺼낸 값 : 동현
//    println("남은 큐 : $queue") // 남은 큐 : [상욱, 준호]
//}

import java.util.ArrayDeque

fun main() {
    var deque = ArrayDeque<String>()
    // 앞쪽에 추가 (addFirst)
    deque.addFirst("앞-1")
    deque.addFirst("앞-2")

    // 뒤쪽에 추가 (addLast / 기본 add)
    deque.addLast("뒤-1")
    deque.add("뒤-2")

    println("현재 덱 : $deque") // 현재 덱 : [앞-2, 앞-1, 뒤-1, 뒤-2]

    //덱에서의 pop, poll()은 앞에서 추출함.
    val front = deque.removeFirst()
    println("앞에서 꺼냄: $front") // 앞에서 꺼냄: 앞-2

    val back = deque.removeLast()
    println("뒤에서 꺼냄: $back") // 뒤에서 꺼냄: 뒤-2

    println("남은 덱: $deque") // 남은 덱: [앞-1, 뒤-1]
}