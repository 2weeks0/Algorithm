package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine().toInt()
    for (i in 0 until t) {
        val stringTokenizer = StringTokenizer(readLine())
        val m = stringTokenizer.nextToken().toInt()
        val n = stringTokenizer.nextToken().toInt()
        val x = stringTokenizer.nextToken().toInt()
        val y = stringTokenizer.nextToken().toInt()

        val lsm = m * n / gcd(m, n)
        var hasAnswer = false
        for (j in 0 until lsm / m) {
            val num = j * m + x
            if ((num - 1) % n == y - 1) {
                bufferedWriter.append("$num\n")
                hasAnswer = true
                break
            }
        }
        if (!hasAnswer) {
            bufferedWriter.append("-1\n")
        }
    }

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun gcd(a: Int, b: Int): Int {
    return when {
        b > a -> gcd(b, a)
        b == 0 -> a
        else -> gcd(b, a % b)
    }
}
