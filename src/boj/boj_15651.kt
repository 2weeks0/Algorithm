package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val stringBuilder = StringBuilder()
    val stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()
    val numList = LinkedList<Int>()

    fun dfs() {
        if (numList.size == m) {
            numList.forEach {
                stringBuilder.append("${it + 1} ")
            }
            stringBuilder.append('\n')
            return
        }

        for (i in 0 until n) {
            numList.addLast(i)
            dfs()
            numList.pollLast()
        }
    }

    dfs()

    bufferedWriter.write(stringBuilder.toString())
    bufferedWriter.close()
    close()
}