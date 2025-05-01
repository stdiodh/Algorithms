package aandi.`2week`

class Human (
    // 생성자
    private val name: String, private val age: Int
) {

    init {
        // 생성자 블록
        println("${name}은(는) 사람입니다.")
    }

    fun printAge() {
        println("나이는 ${age}살 입니다.")
    }

    // Kotlin은 명시적인 소멸자(Destructor)는 없음.
}

class Box<T> (private val value : T){
    fun printValue() {
        println("값은 $value")
    }
}

//fun main() {
//    val human = Human("동현", 24) // 인스턴스
//    human.printAge() // 메소드 호출
//
//    val link : LinkedList<Int> = linkedSetOf(1, 2, 3, )
//}


open class Animal {
    open fun speak() = println("동물 소리")
}

class Cat : Animal() {
    override fun speak() {
        println("야옹!")
    }
}

