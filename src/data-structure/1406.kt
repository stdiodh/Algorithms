package BOJ.Structure

import java.io.StreamTokenizer
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun next(): String { nextToken(); return sval }
    fun nextInt(): Int { nextToken(); return nval.toInt() }

    val str = LinkedList<Char>()
    next().forEach { str.add(it) }

    val n = nextInt()
    val cursor: MutableListIterator<Char> = str.listIterator(str.size)

    repeat(n) {
        when (val command = next()) {
            "L" -> if (cursor.hasPrevious()) cursor.previous()
            "D" -> if (cursor.hasNext()) cursor.next()
            "B" -> if (cursor.hasPrevious()) {
                cursor.previous()
                cursor.remove()
            }
            "P" -> {
                val ch = next().first()
                cursor.add(ch)
            }
        }
    }

    print(str.joinToString(""))
}
