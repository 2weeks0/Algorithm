package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

val memorization = IntArray(1000001) { -1 }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine().toInt()
    for (i in 0 until t) {
        val n = readLine().toInt()
        var answer = 0
        for (j in 2 .. n / 2) {
            if (j.isPrime() && (n - j).isPrime()) {
                answer++
            }
        }
        bufferedWriter.append("$answer\n")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun Int.isPrime(): Boolean {
    if (memorization[this] == -1) {
        for (i in 2 .. sqrt(this.toDouble()).toInt()) {
            if (this % i == 0) {
                memorization[this] = 0
                break
            }
        }
        if (memorization[this] == -1) {
            memorization[this] = 1
        }
    }
    return memorization[this] == 1
}