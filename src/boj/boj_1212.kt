package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val array = arrayOf(4, 2, 1)
    val input = readLine()

    val answer = StringBuilder()
    for (c in input) {
        var temp = c - '0'
        for (i in array) {
            if (temp >= i) {
                answer.append(1)
                temp -= i
            } else {
                answer.append(0)
            }
        }
    }

    while (answer.first() == '0' && answer.length > 1) {
        answer.deleteCharAt(0)
    }

    println(answer)
    close()
}