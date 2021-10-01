package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    var stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()
    stringTokenizer = StringTokenizer(readLine())
    val input = IntArray(n) {
        stringTokenizer.nextToken().toInt()
    }.sorted()
    val numList = LinkedList<Int>()

    fun bt() {
        if (numList.size == m) {
            numList.forEach {
                bufferedWriter.append("$it ")
            }
            bufferedWriter.newLine()
            return
        }

        for (i in input) {
            if (numList.isEmpty() || numList.peekLast() <= i) {
                numList.addLast(i)
                bt()
                numList.pollLast()
            }
        }
    }

    bt()

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}