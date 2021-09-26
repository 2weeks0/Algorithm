package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stack = LinkedList<String>()
    var answer = 0
    val stringBuilder = StringBuilder()
    readLine().forEach {
        when (it) {
            '(' -> {
                stringBuilder.clear()
                stack.addLast(it.toString())
            }
            ')' -> {
                stack.addLast(stringBuilder.toString())
                stack.addLast(it.toString())
                stringBuilder.clear()
            }
            else -> {
                stringBuilder.append(it)
                if (stack.isEmpty()) {
                    stack.addLast(it.toString())
                } else {
                    stack.pollLast()
                    stack.addLast(it.toString())
                    answer++
                }
            }
        }
    }

    println(stack)
    println(answer)
}
