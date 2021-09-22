package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stringTokenizer = StringTokenizer(readLine())
    val m = stringTokenizer.nextToken().toInt()
    val n = stringTokenizer.nextToken().toInt()

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    for (i in m .. n) {
        if (i.isPrime()) {
            bufferedWriter.append("$i\n")
        }
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun Int.isPrime(): Boolean {
    if (this == 1) {
        return false
    }

    for (i in 2 .. sqrt(this.toDouble()).toInt()) {
        if (this % i == 0) {
            return false
        }
    }

    return true
}