package aandi.`5week`

open class Parent {
    open fun textPrint() {
        print("text를 출력하는 부모메서드 입니다.")
    }
}

class Child1 : Parent(){
    override fun textPrint() {
        println("오버라이딩된 텍스트 1")
    }
}

class Child2 : Parent(){
    override fun textPrint() {
        println("오버라이딩된 텍스트 2")
    }
}

fun main(){
    val text1 : Parent = Child1()
    val text2 : Parent = Child2()
    text1.textPrint() // 오버라이딩된 텍스트 1
    text2.textPrint() // 오버라이딩된 텍스트 2
}