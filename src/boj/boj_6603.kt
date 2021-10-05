package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

const val SIZE = 6

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val stringTokenizer = StringTokenizer(readLine())
        val n = stringTokenizer.nextToken().toInt()
        if (n == 0) {
            break
        }
        val input = IntArray(n) {
            stringTokenizer.nextToken().toInt()
        }
        val visited = BooleanArray(n)
        val list = LinkedList<Int>()

        fun bt() {
            if (list.size == SIZE) {
                list.forEach {
                    bufferedWriter.append("$it ")
                }
                bufferedWriter.newLine()
                return
            }

            for (i in input.indices) {
                if (!visited[i] && (list.isEmpty() || list.peekLast() < input[i])) {
                    visited[i] = true
                    list.addLast(input[i])
                    bt()
                    list.pollLast()
                    visited[i] = false
                }
            }
        }
        bt()
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}