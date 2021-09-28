package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val cache = IntArray(n + 1).apply {
        this[1] = 1
    }

    for (i in 2..n) {
        val root = sqrt(i.toDouble())
        cache[i] = if (root - root.toInt() == 0.0) {
            1
        } else {
            var temp = 100000
            for (j in 1..root.toInt()) {
                val jSquare = j.toDouble().pow(2).toInt()
                temp = min(temp, cache[i - jSquare] + cache[jSquare])
            }
            temp
        }
    }

    println(cache[n])
    close()
}

