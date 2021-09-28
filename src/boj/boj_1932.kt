package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val input = Array(n) { i ->
        val stringTokenizer = StringTokenizer(readLine())
        IntArray(n) { j ->
            if (j <= i) {
                stringTokenizer.nextToken().toInt()
            } else {
                0
            }
        }
    }

    val cache = Array(n) { IntArray(n) }.apply {
        this[0][0] = input[0][0]
    }
    for (i in 1 until n) {
        for (j in 0 until i) {
            cache[i][j] = max(cache[i][j], cache[i - 1][j] + input[i][j])
            cache[i][j + 1] = max(cache[i][j + 1], cache[i - 1][j] + input[i][j + 1])
        }
    }

    var answer = 0
    for (i in 0 until n) {
        answer = max(answer, cache[n - 1][i])
    }
    println(answer)
    close()
}