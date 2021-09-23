package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var stringTokenizer = StringTokenizer(readLine())
    val a = stringTokenizer.nextToken().toInt()
    val b = stringTokenizer.nextToken().toInt()
    val m = readLine().toInt()

    var num = 0
    stringTokenizer = StringTokenizer(readLine())
    for (i in m - 1 downTo 0) {
        num += stringTokenizer.nextToken().toInt() * a.toDouble().pow(i).toInt()
    }

    val stack = LinkedList<Int>()
    do {
        stack.addLast(num % b)
        num /= b
    } while (num != 0)

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    while (stack.isNotEmpty()) {
        bufferedWriter.append("${stack.pollLast()} ")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}