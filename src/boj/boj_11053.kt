package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val cache = IntArray(n + 1) { 1 }

    val input = IntArray(n + 1)
    val stringTokenizer = StringTokenizer(readLine())
    for (i in 1 .. n) {
        input[i] = stringTokenizer.nextToken().toInt()
    }

    for (i in n - 1 downTo 1) {
        for (j in i + 1 .. n) {
            if (input[i] < input[j]) {
                cache[i] = max(cache[i], cache[j] + 1)
            }
        }
    }

    var answer = 0
    for (i in 1 .. n) {
        answer = max(answer, cache[i])
    }

    println(answer)
    close()
}
