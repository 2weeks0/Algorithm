package boj

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val answer = LinkedList<Char>()
    val stack = LinkedList<Int>()
    val n = readLine().toInt()
    var i = 1
    for (j in 0 until n) {
        val m = readLine().toInt()
        if (i <= m) {
            while (i <= m) {
                stack.addLast(i++)
                answer.addLast('+')
            }
            stack.pollLast()
            answer.addLast('-')
        } else {
            do {
                val pop = stack.pollLast()
                if (pop != m) {
                    println("NO")
                    return@with
                }
                answer.addLast('-')
            } while (pop != m)
        }
    }

    val bufferedWriter = System.out.bufferedWriter()
    answer.forEach {
        bufferedWriter.append("$it\n")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
}