package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val mod = 1000000000
    val n = readLine().toInt()
    val cache = Array(n + 1) { IntArray(10) }
    for (i in 0..9) {
        cache[1][i] = if (i == 0) 0 else 1
    }

    for (i in 2..n) {
        for (j in 0..9) {
            cache[i][j] = when (j) {
                0 -> cache[i - 1][1]
                9 -> cache[i - 1][8]
                else -> (cache[i - 1][j - 1] + cache[i - 1][j + 1]) % mod
            }
        }
    }

    var answer: Long = 0
    for (i in 0..9) {
        answer += cache[n][i]
        answer %= mod
    }
    println(answer)

    close()
}
