package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val input = with(StringTokenizer(readLine())) {
        IntArray(n) {
            nextToken().toInt()
        }
    }

    val dp = Array(n) { IntArray(2) }
    for (i in 0 until n) {
        dp[i][0] = when (i) {
            0 -> -1001
            1 -> max(input[i], input[i - 1])
            else -> max(dp[i - 1][1], dp[i - 1][0] + input[i])
        }
        dp[i][1] = when (i) {
            0 -> input[i]
            else -> max(dp[i - 1][1] + input[i], input[i])
        }
    }

    var answer = -1001
    for (i in 0 until n) {
        for (j in 0..1) {
            answer = max(answer, dp[i][j])
        }
    }

    println(answer)
    close()
}