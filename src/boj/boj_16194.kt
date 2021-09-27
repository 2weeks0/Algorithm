package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stringTokenizer = StringTokenizer(readLine())

    val price = IntArray(n + 1)
    for (i in 1 .. n) {
        price[i] = stringTokenizer.nextToken().toInt()
    }

    val answer = IntArray(n + 1) { 10000000 }
    for (i in 1 .. n) {
        for (j in i .. n) {
            if (j % i == 0) {
                answer[j] = min(answer[j], j / i * price[i])
            } else {
                answer[j] = min(answer[j - i] + answer[i], answer[j])
            }
        }
    }

    println(answer[n])
    close()
}