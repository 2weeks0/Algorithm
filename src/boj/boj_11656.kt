package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val string = readLine()
    val answer = ArrayList<String>()
    for (i in string.indices) {
        answer.add(string.substring(i, string.lastIndex + 1))
    }

    answer.sort()

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    for (s in answer) {
        bufferedWriter.append("$s\n")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}