package boj_10422

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

const val MOD = 1000000007
val cache = IntArray(2501) { -1 }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine().toInt()
    repeat(t) {
        val input = readLine().toInt()
        if (input % 2 == 1) {
            bufferedWriter.append("0\n")
        } else {
            bufferedWriter.append("${catalanNum(input / 2)}\n")
        }
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

fun catalanNum(n: Int): Int {
    if (n == 0) {
        return 1
    } else if (cache[n] != -1) {
        return cache[n]
    }

    var result = 0
    for (i in 0 until n) {
        result += ((catalanNum(i).toLong() * catalanNum(n - 1 - i)) % MOD).toInt()
        result %= MOD
    }
    cache[n] = result
    return result
}