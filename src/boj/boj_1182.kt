package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.log2
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val s = stringTokenizer.nextToken().toInt()
    stringTokenizer = StringTokenizer(readLine())
    val input = IntArray(n) {
        stringTokenizer.nextToken().toInt()
    }

    val indexes = IntArray(n) { 2.pow(it) }

    var answer = 0
    for (i in 1 until 2.pow(n)) {
        var sum = 0
        for (j in 0 .. log2(i.toDouble()).toInt()) {
            if (i and indexes[j] == indexes[j]) {
                sum += input[j]
            }
        }
        if (sum == s) {
            answer++
        }
    }

    println(answer)
    close()
}

private fun Int.pow(n: Int) = toDouble().pow(n).toInt()