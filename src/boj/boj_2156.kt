package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val input = IntArray(n) {
        readLine().toInt()
    }

    val dp = Array(3) { IntArray(n) }
    for (i in 0 until n) {
        if (i == 0) {
            dp[0][i] = 0
            dp[1][i] = input[i]
            dp[2][i] = input[i]
        } else {
            dp[0][i] = max(dp[2][i - 1], max(dp[1][i - 1], dp[0][i - 1]))
            dp[1][i] = dp[0][i - 1] + input[i]
            dp[2][i] = dp[1][i - 1] + input[i]
        }
    }

    println(max(dp[0][n - 1], max(dp[1][n - 1], dp[2][n - 1])))
    close()
}