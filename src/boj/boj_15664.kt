package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val stringBuilder = StringBuilder()
    var stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()
    stringTokenizer = StringTokenizer(readLine())
    val input = IntArray(n) {
        stringTokenizer.nextToken().toInt()
    }.sorted()
    val numList = LinkedList<Int>()
    val answerSet = HashSet<String>()
    var preIndex = -1

    fun bt() {
        if (numList.size == m) {
            numList.forEach {
                stringBuilder.append("$it ")
            }
            if (!answerSet.contains(stringBuilder.toString())) {
                answerSet.add(stringBuilder.toString())
                bufferedWriter.append(stringBuilder.toString())
                bufferedWriter.newLine()
            }
            stringBuilder.clear()
            return
        }

        for (i in input.indices) {
            if (preIndex < i) {
                val temp = preIndex
                preIndex = i
                numList.addLast(input[i])
                bt()
                numList.pollLast()
                preIndex = temp
            }
        }
    }

    bt()

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}