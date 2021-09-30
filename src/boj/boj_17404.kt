package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val input = Array(n + 1) { IntArray(3) }
    for (i in 1..n) {
        val stringTokenizer = StringTokenizer(readLine())
        for (j in 0..2) {
            input[i][j] = stringTokenizer.nextToken().toInt()
        }
    }

    var answer = n * 1000
    val dp = Array(n + 1) { Array(3) { IntArray(3) { n * 1000 } } }
    for (i in 2..n) {
        for (j in 0..2) {
            for (k in 0..2) {
                dp[i][j][k] = input[i][k] + when {
                    i == 2 && j != k -> input[1][j]
                    k == 0 -> min(dp[i - 1][j][1], dp[i - 1][j][2])
                    k == 1 -> min(dp[i - 1][j][2], dp[i - 1][j][0])
                    else -> min(dp[i - 1][j][1], dp[i - 1][j][0])
                }
                if (i == n && j != k) {
                    answer = min(answer, dp[i][j][k])
                }
            }
        }
    }

    println(answer)
    close()
}