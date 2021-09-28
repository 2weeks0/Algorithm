package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stringTokenizer = StringTokenizer(readLine())

    val input = IntArray(n + 1)
    for (i in 1..n) {
        input[i] = stringTokenizer.nextToken().toInt()
    }

    val cache = IntArray(n + 1) { 1 }
    for (i in 2..n) {
        for (j in 1 until i) {
            if (input[i] < input[j]) {
                cache[i] = max(cache[i], cache[j] + 1)
            }
        }
    }

    var answer = 0
    for (i in cache) {
        answer = max(answer, i)
    }
    println(answer)
    close()
}