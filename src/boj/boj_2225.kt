package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val k = stringTokenizer.nextToken().toInt()

    val cache = Array(n + 1) { i -> IntArray(k + 1) { if (i == 0) 1 else 0 } }

    for (i in 1..n) {
        for (j in 1..k) {
            cache[i][j] = ((cache[i - 1][j].toLong() + cache[i][j - 1]) % 1000000000).toInt()
        }
    }

    println(cache[n][k])
    close()
}