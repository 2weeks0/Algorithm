package boj

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val input = readLine()
    var open = false
    val stack = LinkedList<Char>()
    for (c in input) {
        when (c) {
            '<' -> {
                while (stack.isNotEmpty()) {
                    bufferedWriter.append(stack.pollLast())
                }
                open = true
                bufferedWriter.append(c)
            }
            '>' -> {
                open = false
                bufferedWriter.append(c)
            }
            ' ' -> {
                if (!open) {
                    while (stack.isNotEmpty()) {
                        bufferedWriter.append(stack.pollLast())
                    }
                }
                bufferedWriter.append(c)
            }
            else -> {
                if (open) {
                    bufferedWriter.append(c)
                } else {
                    stack.addLast(c)
                }
            }
        }
    }
    while (stack.isNotEmpty()) {
        bufferedWriter.append(stack.pollLast())
    }
    bufferedWriter.flush()
    bufferedWriter.close()
}