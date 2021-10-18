package boj_1427

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var n: String
val cnt = IntArray(10)

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    for (i in 9 downTo 0) {
        repeat(cnt[i]) {
            append("$i")
        }
    }
    flush()
    close()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine()
    n.forEach {
        cnt[it - '0']++
    }
    close()
}