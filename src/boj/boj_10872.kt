package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    println(factorial(n))
    close()
}

private fun factorial(n: Int): Int {
    return if (n <= 1) {
        1
    } else {
        n * factorial(n - 1)
    }
}