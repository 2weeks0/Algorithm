package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Long.max
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var answer: Long = 0
    val stack = LinkedList<Hist>()
    val n = readLine().toInt()
    for (i in 0 .. n + 1) {
        val hist = if (i == 0 || i == n + 1) {
            Hist(i, 0)
        } else {
            Hist(i, readLine().toLong())
        }

        var top = stack.peekLast()
        while (top != null && top.height > hist.height) {
            val height = top.height
            stack.pollLast()
            top = stack.peekLast()
            val width = hist.index - top.index - 1
//            println("height: $height, width: $width")
            answer = max(answer, width * height)
        }
        stack.add(hist)
//        println("stack: $stack, answer: $answer")
    }
    println(answer)
}

class Hist(
    val index: Int,
    val height: Long
) {
    override fun toString(): String {
        return "($index, $height)"
    }
}