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

    val cache = Array(n + 1) { IntArray(2) { 1 } }
    for (i in 2..n) {
        for (j in 1 until i) {
            if (input[i] > input[j]) {
                cache[i][0] = max(cache[i][0], cache[j][0] + 1)
            }
        }
    }

    for (i in n-1 downTo 1) {
        for (j in i+1..n) {
            if (input[i] > input[j]) {
                cache[i][1] = max(cache[i][1], cache[j][1] + 1)
            }
        }
    }

    var answer = 0
    for(i in 1..n) {
        answer = max(answer, cache[i][0] + cache[i][1] - 1)
    }
    println(answer)
    close()
}