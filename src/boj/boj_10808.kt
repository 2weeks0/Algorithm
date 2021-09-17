package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cntArray = IntArray(26)
    val input = readLine()
    for (char in input) {
        cntArray[char - 'a'] += 1
    }

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    for (cnt in cntArray) {
        bufferedWriter.append("$cnt ")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
}