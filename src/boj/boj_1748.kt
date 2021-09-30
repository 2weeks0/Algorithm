package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val length = n.toString().length

    var answer = 0
    for (i in 1 .. length) {
        answer += 9 * 10.toDouble().pow(i - 1).toInt() * i
    }
    answer -= length * (10.toDouble().pow(length).toInt() - 1 - n)

    println(answer)
    close()
}