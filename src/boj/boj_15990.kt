package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val limit = 1000000009
    val t = readLine().toInt()
    val cache = Array(100001) { IntArray(4) }.apply {
        this[1][1] = 1
        this[2][2] = 1
        this[3][1] = 1
        this[3][2] = 1
        this[3][3] = 1
    }

    for (i in 4..100000) {
        cache[i][1] = (cache[i - 1][2] + cache[i - 1][3]) % limit
        cache[i][2] = (cache[i - 2][1] + cache[i - 2][3]) % limit
        cache[i][3] = (cache[i - 3][1] + cache[i - 3][2]) % limit
    }

    for (j in 0 until t) {
        val i = readLine().toInt()
        println((cache[i][1].toLong() + cache[i][2] + cache[i][3]) % limit)
    }
    close()
}