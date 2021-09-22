package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    for (i in 0 until t) {
        val stringTokenizer = StringTokenizer(readLine())
        val n = stringTokenizer.nextToken().toInt()
        val input = IntArray(n)
        for (ii in 0 until n) {
            input[ii] = stringTokenizer.nextToken().toInt()
        }
        input.sort()
        var answer: Long = 0
        for (j in 0 .. input.size - 2) {
            for (k in j + 1 .. input.size - 1) {
                answer += gcd(input[k], input[j])
            }
        }
        println(answer)
    }
    close()
}

private fun gcd(m: Int, n: Int): Int {
    return if (n == 0) {
        m
    } else {
        gcd(n, m % n)
    }
}