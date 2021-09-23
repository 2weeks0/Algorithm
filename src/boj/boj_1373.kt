package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine()
    val answerSize = if (input.length % 3 == 0) {
        input.length / 3
    } else {
        input.length / 3 + 1
    }
    val answer = IntArray(answerSize)
    for (i in input.length - 1 downTo 0 step 3) {
        for (j in 0..2) {
            if (i - j >= 0 && input[i - j] == '1') {
                answer[i / 3] += 2.toDouble()
                    .pow(j.toDouble())
                    .toInt()
            }
        }
    }

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    for (i in answer.indices) {
        bufferedWriter.append("${answer[i]}")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}