package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stringTokenizer = StringTokenizer(readLine())

    val price = IntArray(n + 1)
    for (i in 1 .. n) {
        price[i] = stringTokenizer.nextToken().toInt()
    }

    val answer = IntArray(n + 1)
    for (i in 1 .. n) {
        for (j in i .. n) {
            if (j % i == 0) {
                answer[j] = max(answer[j], j / i * price[i])
            } else {
                answer[j] = max(answer[j - i] + answer[i], answer[j])
            }
//            print("${answer[j]} ")
        }
//        println()
    }

    println(answer[n])
    close()
}