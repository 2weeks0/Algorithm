package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()

    for (i in 0 until t) {
        val stringTokenizer = StringTokenizer(readLine())
        val a = stringTokenizer.nextToken().toInt()
        val b = stringTokenizer.nextToken().toInt()
        val gcd = if (a > b) gcd(a, b) else gcd(b, a)
        println(a * b / gcd)
    }
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        gcd(b, a % b)
    }
}