package boj_5557

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
lateinit var numbers: IntArray

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    numbers = with(StringTokenizer(readLine())) {
        IntArray(n) {
            nextToken().toInt()
        }
    }
    close()
}

fun solve() {
    val cache = Array(n - 1) { LongArray(21) }
    cache[0][numbers[0]] = 1

    for (r in 1 until n - 1) {
        for (c in 0..20) {
            if (c + numbers[r] <= 20) {
                cache[r][c] += cache[r - 1][c + numbers[r]]
            }
            if (0 <= c - numbers[r]) {
                cache[r][c] += cache[r - 1][c - numbers[r]]
            }
        }
    }

    println(cache[n - 2][numbers[n - 1]])
}
