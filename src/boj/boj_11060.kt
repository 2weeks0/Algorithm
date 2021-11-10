package boj_11060

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var n = 0
lateinit var stairs: IntArray

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    stairs = with(StringTokenizer(readLine())) {
        IntArray(n) {
            nextToken().toInt()
        }
    }
    close()
}

fun solve() {
    val cache = IntArray(n) { Int.MAX_VALUE }.apply { this[0] = 0 }
    for (i in 0 until n) {
        if (cache[i] == Int.MAX_VALUE) {
            continue
        }
        for (j in 1..stairs[i]) {
            if (n <= i + j) {
                continue
            }
            cache[i + j] = min(cache[i + j], cache[i] + 1)
        }
    }

    println(if (cache[n - 1] == Int.MAX_VALUE) -1 else cache[n - 1])
}