package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val cache = IntArray(n + 1)

    for (i in 2..n) {
        cache[i] = when {
            i % 6 == 0 -> {
                min(cache[i - 1] + 1, min(cache[i / 3] + 1, cache[i / 2] + 1))
            }
            i % 3 == 0 -> {
                min(cache[i - 1] + 1, cache[i / 3] + 1)
            }
            i % 2 == 0 -> {
                min(cache[i - 1] + 1, cache[i / 2] + 1)
            }
            else -> {
                cache[i - 1] + 1
            }
        }
    }

    println(cache[n])
    close()
}