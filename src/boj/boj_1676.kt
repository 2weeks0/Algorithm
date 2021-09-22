package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    println(func(n))
    close()
}

private fun func(n: Int): Int {
    return when {
        n < 5 -> {
            0
        }
        n % 5 == 0 -> {
            var cnt = 0
            var temp = n
            while (temp % 5 == 0) {
                cnt++
                temp /= 5
            }
            cnt + func(n - 1)
        }
        else -> {
            func(n - 1)
        }
    }
}