package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val m = readLine().toInt()

    var answer = abs(n - 100)
    if (m in 0..9) {
        val isBroken = BooleanArray(10) { false }
        if (0 < m) {
            val stringTokenizer = StringTokenizer(readLine())
            for (i in 0 until m) {
                isBroken[stringTokenizer.nextToken().toInt()] = true
            }
        }

        var r = n
        var l = n - 1
        while (true) {
            if (r.toString().indexOfFirst { isBroken[it - '0'] } == -1) {
                answer = min(answer, r.toString().length + r - n)
                break
            } else if (l >= 0 && l.toString().indexOfFirst { isBroken[it - '0'] } == -1) {
                answer = min(answer, l.toString().length + n - l)
                break
            }
            r++
            l--
        }
    }

    println(answer)
    close()
}