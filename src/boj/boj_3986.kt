package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    val stack = LinkedList<Char>()
    var answer = 0
    for (i in 0 until t) {
        val input = readLine()
        for (c in input) {
            if (stack.isEmpty()) {
                stack.addLast(c)
            } else {
                val peek = stack.peekLast()
                if (peek != c) {
                    stack.addLast(c)
                } else {
                    stack.pollLast()
                }
            }
        }
        if (stack.isEmpty()) {
            answer++
        }
        stack.clear()
    }
    println(answer)
}