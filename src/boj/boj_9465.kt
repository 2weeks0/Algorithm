package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.max
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val T = readLine().toInt()
    for (t in 0 until T) {
        val n = readLine().toInt()
        val input = Array(2) {
            val stringTokenizer = StringTokenizer(readLine())
            IntArray(n) {
                stringTokenizer.nextToken().toInt()
            }
        }

        val dp = Array(2) { IntArray(n) }

        for (i in 0 until n) {
            dp[0][i] = if (i == 0) {
                input[0][i]
            } else {
                max(dp[1][i - 1] + input[0][i], dp[0][i - 1])
            }

            dp[1][i] = if (i == 0) {
                input[1][i]
            } else {
                max(dp[0][i - 1] + input[1][i], dp[1][i - 1])
            }
        }

        bufferedWriter.append("${max(dp[0][n - 1], dp[1][n - 1])}\n")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}