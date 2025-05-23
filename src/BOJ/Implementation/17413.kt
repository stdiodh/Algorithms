package BOJ.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    //최종 출력
    val word = StringBuilder()
    //현재 처리 중인 부분 문자열
    val sb = StringBuilder()
    var flag = false

    for(i in str.indices){
        when(str[i]){
            '<' -> {
                if(sb.isNotEmpty()){
                    word.append(sb.reverse())
                    sb.setLength(0)
                }
                sb.append('<')
                flag = true
            }
            '>' -> {
                sb.append('>')
                flag = false
                word.append(sb)
                sb.setLength(0)
            }
            ' ' -> {
                if(!flag){
                    sb.reverse().append(' ')
                    word.append(sb)
                    sb.setLength(0)
                } else sb.append(' ')
            }
            else -> {
                sb.append(str[i])
            }
        }
    }

    if (!flag) {
        word.append(sb.reverse())
    }

    print(word)
}
