package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()
    val numList = LinkedList<Int>()

    fun dfs() {
        if (numList.size == m) {
            numList.forEach {
                bufferedWriter.append("${it + 1} ")
            }
            bufferedWriter.newLine()
            return
        }

        for (i in 0 until n) {
            if (numList.isEmpty() || numList.peekLast() <= i) {
                numList.addLast(i)
                dfs()
                numList.pollLast()
            }
        }
    }

    dfs()

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}