package aandi.`5week`

open class Parent {
    open fun textPrint() {
        print("text를 출력하는 부모메서드 입니다.")
    }
}

class Text1 : Parent(){
    override fun textPrint() {
        print("오버라이딩 텍스트 1")
    }
}

fun main(){
    val text : Parent = Text1()
    text.textPrint() // 오버라이딩 텍스트 1
}