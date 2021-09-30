package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    for (i in 2.pow(m) - 1 until 2.pow(n)) {
        var cnt = 0
        for (j in 0 .. n) {
            if (i and 2.pow(j) == 2.pow(j)) {
                cnt++
            }
        }
        if (cnt == m) {
            for (k in 0 until n) {
                if (i and 2.pow(k) == 2.pow(k)) {
                    bufferedWriter.append("${k + 1} ")
                }
            }
            bufferedWriter.append('\n')
        }
    }

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun Int.pow(n: Int) = toDouble().pow(n).toInt()