package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine().toInt()
    val cache = IntArray(11)
    for (i in 0 until t) {
        bufferedWriter.append("${func(readLine().toInt(), cache)}\n")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun func(n: Int, cache: IntArray): Int {
    if (cache[n] != 0) {
        return cache[n]
    }

    cache[n] = when (n) {
        1 -> 1
        2 -> 2
        3 -> 4
        else -> func(n - 3, cache) + func(n - 2, cache) + func(n - 1, cache)
    }
    return cache[n]
}