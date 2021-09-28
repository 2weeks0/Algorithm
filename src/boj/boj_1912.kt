package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val input = IntArray(n + 1)
    val stringTokenizer = StringTokenizer(readLine())
    for (i in 1..n) {
        input[i] = stringTokenizer.nextToken().toInt()
    }

    val cache = IntArray(n + 1).apply {
        this[1] = input[1]
    }
    for (i in 2..n) {
        cache[i] = max(input[i], cache[i - 1] + input[i])
    }

    var answer = -1000
    for (i in 1 .. n) {
        answer = max(answer, cache[i])
    }
    println(answer)
    close()
}