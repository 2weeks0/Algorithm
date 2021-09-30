package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val dp = IntArray(n + 1)
    for (i in 0..n step 2) {
        dp[i] = when (i) {
            0 -> 1
            2 -> 3
            else -> {
                var result = dp[i - 2] * dp[2]
                for (j in i - 4 downTo 0 step 2) {
                    result +=  2 * dp[j]
                }
                result
            }
        }
    }

    println(dp[n])
    close()
}