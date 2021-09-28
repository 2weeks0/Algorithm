package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val cache = Array(n + 1) { LongArray(3) }.apply {
        this[1][0] = 0
        this[1][1] = 1
    }

    for (i in 2..n) {
        cache[i][1] = cache[i - 1][0]
        cache[i][0] = cache[i - 1][1] + cache[i - 1][0]
    }

    println(cache[n][1] + cache[n][0])
    close()
}