package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

const val E = 15
const val S = 28
const val M = 19

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val stringTokenizer = StringTokenizer(readLine())
    val e = stringTokenizer.nextToken().toInt()
    val s = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    var answer = 0
    while (!(answer % E + 1 == e && answer % S + 1 == s && answer % M + 1 == m)) {
        answer++
    }

    println(answer + 1)
    close()
}