package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    var n = readLine().toInt()

    var m = 2
    while (n != 1) {
        if (n % m == 0) {
            n /= m
            bufferedWriter.append("$m\n")
        } else {
            m++
        }
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}