package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    var max = 3
    val input = IntArray(t) {
        val i = readLine().toInt()
        max = max(max, i)
        i
    }

    val cache = IntArray(max).apply {
        this[0] = 1
        this[1] = 2
        this[2] = 4
    }
    for (i in 3 until max) {
        cache[i] = ((cache[i - 1].toLong() + cache[i - 2] + cache[i - 3]) % 1000000009).toInt()
    }

    for (i in input) {
        println(cache[i - 1])
    }
}