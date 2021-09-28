package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val dp = Array(n + 1) { i ->
        IntArray(10) {
            if (i == 1) {
                1
            } else {
                0
            }
        }
    }

    for (i in 2..n) {
        for (j in 0 until 10) {
            for (k in 0..j) {
                dp[i][j] += dp[i - 1][k]
                dp[i][j] %= 10007
            }
        }
    }

    var answer = 0
    for (i in dp[n]) {
        answer += i
    }
    println(answer % 10007)
    close()
}