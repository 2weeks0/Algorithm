package boj

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val left = LinkedList<Char>()
    val right = LinkedList<Char>()

    val string = readLine()
    for (c in string) {
        left.add(c)
    }

    val m = readLine().toInt()

    for (i in 0 until m) {
        val input = readLine();
        when (input.first()) {
            'L' -> {
                if (left.isNotEmpty()) {
                    right.addFirst(left.pollLast())
                }
            }
            'D' -> {
                if (right.isNotEmpty()) {
                    left.addLast(right.pollFirst())
                }
            }
            'B' -> {
                if (left.isNotEmpty()) {
                    left.pollLast()
                }
            }
            'P' -> {
                left.addLast(input.last())
            }
        }
    }

    val bufferedWriter = System.out.bufferedWriter()

    left.forEach {
        bufferedWriter.append(it)
    }
    right.forEach {
        bufferedWriter.append(it)
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}