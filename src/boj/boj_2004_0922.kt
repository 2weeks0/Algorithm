package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val cntOf2 = getCntOfXInNFactorial(n, 2) - getCntOfXInNFactorial(n - m, 2) - getCntOfXInNFactorial(m, 2)
    val cntOf5 = getCntOfXInNFactorial(n, 5) - getCntOfXInNFactorial(n - m, 5) - getCntOfXInNFactorial(m, 5)
    println(min(cntOf2, cntOf5))

    close()
}

private fun getCntOfXInNFactorial(n: Int, x: Int): Long {
    var result = 0.toLong()

    var temp = n
    while (temp >= x) {
        result += temp / x
        temp /= x
    }

    return result
}