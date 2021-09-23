package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readLine().toInt()
    val stack = LinkedList<Int>()

    do {
       var left = n % -2
       n /= -2

       if (left == -1) {
           n += 1
           left = 1
       }
        stack.addLast(left)
    } while (n != 0)

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    while (stack.isNotEmpty()) {
        bufferedWriter.append("${stack.pollLast()}")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}