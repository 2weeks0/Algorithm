package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stringTokenizer = StringTokenizer(readLine())
    var n = stringTokenizer.nextToken().toInt()
    val b = stringTokenizer.nextToken().toInt()

    val stack = LinkedList<Char>()
    do {
        val left = n % b
        n /= b
        if (left >= 10) {
            stack.addLast('A' + left - 10)
        } else {
            stack.addLast('0' + left)
        }
    } while (n != 0)

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    while (stack.isNotEmpty()) {
        bufferedWriter.append("${stack.pollLast()}")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}