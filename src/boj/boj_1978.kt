package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stringTokenizer = StringTokenizer(readLine())
    var answer = 0
    for (i in 0 until n) {
        val num = stringTokenizer.nextToken().toInt()
        if (num.isPrime()) {
            answer++
        }
    }
    println(answer)
}

private fun Int.isPrime(): Boolean {
    if (this == 1) {
        return false
    }

    for (i in 2..sqrt(this.toDouble()).toInt()) {
        if (this % i == 0) {
            return false
        }
    }
    return true
}