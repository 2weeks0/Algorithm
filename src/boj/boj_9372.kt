package boj_9372

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        with(StringTokenizer(readLine())) {
            val n = nextToken().toInt()
            val m = nextToken().toInt()
            println(n - 1)
            repeat(m) {
                readLine()
            }
        }
    }
}