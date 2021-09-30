package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var sum = 0
    val input = IntArray(9) {
        readLine().toInt().also {
            sum += it
        }
    }.sorted()

    for (i in 0 until input.size - 1) {
        for (j in i + 1 until input.size) {
            if (sum - input[i] - input[j] == 100) {
                for (k in input.indices) {
                    if (k != i && k != j) {
                        println(input[k])
                    }
                }
                return@with
            }
        }
    }
}