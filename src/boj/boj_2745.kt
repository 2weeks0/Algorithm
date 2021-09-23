package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken()
    val b = stringTokenizer.nextToken()
        .toInt()

    var answer = 0
    n.forEachIndexed { index, c ->
        val x = if (c >= 'A') {
            c - 'A' + 10
        } else {
            c - '0'
        }

        answer += x * b.toDouble()
            .pow(n.length - 1 - index)
            .toInt()
    }

    println(answer)
    close()
}