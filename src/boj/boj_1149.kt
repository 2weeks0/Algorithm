package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val input = Array(n) {
        val stringTokenizer = StringTokenizer(readLine())
        IntArray(3) {
            stringTokenizer.nextToken().toInt()
        }
    }

    val cache = Array(n) { IntArray(3) }

    for (i in 0 until n) {
        for (j in 0 until 3) {
            cache[i][j] =  if (i == 0) {
                input[i][j]
            } else {
                input[i][j] + when (j) {
                    0 -> min(cache[i - 1][1], cache[i - 1][2])
                    1 -> min(cache[i - 1][0], cache[i - 1][2])
                    else -> min(cache[i - 1][0], cache[i - 1][1])
                }
            }
        }
    }

    println(min(cache[n - 1][0], min(cache[n - 1][1], cache[n - 1][2])))
    close()
}