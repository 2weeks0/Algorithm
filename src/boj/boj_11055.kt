package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val input = IntArray(n + 1)
    val stringTokenizer = StringTokenizer(readLine())
    for (i in 1..n) {
        input[i] = stringTokenizer.nextToken().toInt()
    }

    val cache = IntArray(n + 1) { i -> input[i] }
    for (i in 2..n) {
        for (j in 1 until i) {
            if (input[j] < input[i]) {
                cache[i] = max(cache[i], cache[j] + input[i])
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