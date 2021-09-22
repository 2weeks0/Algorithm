package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

private val memorized = IntArray(1000000) { -1 }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val n = readLine().toInt()
        if (n == 0) {
            break
        }

        val a = findMinPrimeNumber(n)
        if (a == -1) {
            bufferedWriter.append("Goldbach's conjecture is wrong.\n")
        } else {
            bufferedWriter.append("$n = $a + ${n - a}\n")
        }
    }

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun findMinPrimeNumber(n: Int): Int {
    for (i in 2 .. n / 2) {
        if (i.isPrime() && (n - i).isPrime()) {
            return i
        }
    }
    return -1
}

private fun Int.isPrime(): Boolean {
    if (memorized[this] != -1) {
        return memorized[this] == 1
    }

    if (this == 1) {
        memorized[this] = -1
        return false
    }

    for (i in 2..sqrt(this.toDouble()).toInt()) {
        if (this % i == 0) {
            memorized[this] = -1
            return false
        }
    }

    memorized[this] = 1
    return true
}