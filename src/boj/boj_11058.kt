package boj_11058

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

var n = 0

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    close()
}

fun solve() = with(LongArray(n + 1)) {
    for (i in 1..n) {
        when {
            i <= 6 -> this[i] = i.toLong()
            else -> {
                for (j in 3 until i) {
                    if (0 < j - 3) {
                        this[i] = max(this[i], (j - 1) * this[i - j])
                    }
                }
            }
        }
    }

    println(this[n])
}