package boj

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val bufferedWriter = System.out.bufferedWriter()
    val left = LinkedList<Char>()
    val right = LinkedList<Char>()

    val testCaseCount = readLine().toInt()
    for (i in 0 until testCaseCount) {
        val string = readLine()
        string.forEach {
            when (it) {
                '<' -> {
                    if (left.isNotEmpty()) {
                        right.addFirst(left.pollLast())
                    }
                }
                '>' -> {
                    if (right.isNotEmpty()) {
                        left.addLast(right.pollFirst())
                    }
                }
                '-' -> {
                    if (left.isNotEmpty()) {
                        left.pollLast()
                    }
                }
                else -> {
                    left.addLast(it)
                }
            }
        }

        left.forEach {
            bufferedWriter.append(it)
        }
        left.clear()
        right.forEach {
            bufferedWriter.append(it)
        }
        right.clear()
        bufferedWriter.flush()
        println()
    }
    bufferedWriter.close()
}