package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val cache = IntArray(n)
    for (i in 0 until n) {
        cache[i] = when (i) {
            0 -> 3
            1 -> 7
            else -> (2 * cache[i - 1] + cache[i - 2]) % 9901
        }
    }

    println(cache[n - 1])
    close()
}