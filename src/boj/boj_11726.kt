package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val cache = IntArray(n + 1).apply {
        this[1] = 1
        if (n > 1) {
            this[2] = 2
        }
    }

    for (i in 3..n) {
        cache[i] = (cache[i - 2] + cache[i - 1]) % 10007
    }

    println(cache[n])
    close()
}