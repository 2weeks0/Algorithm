package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val indexArray = Array(26) { -1 }
    val input = readLine()

    for (i in input.indices) {
        val index = input[i] - 'a'
        if (indexArray[index] == -1) {
            indexArray[index] = i
        }
    }

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    for (index in indexArray) {
        bufferedWriter.append("$index ")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
}