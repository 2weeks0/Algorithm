package boj_1890

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dr = arrayOf(1, 0)
val dc = arrayOf(0, 1)
var n = 0
lateinit var map: Array<IntArray>

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    map = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(n) {
                nextToken().toInt()
            }
        }
    }
    close()
}

fun solve() {
    val memo = Array(n) { LongArray(n) }.apply { this[0][0] = 1 }

    fun dp(r: Int, c: Int, memo: Array<LongArray>) {
        if (map[r][c] == 0) {
            return
        }

        for (d in 0 until 2) {
            val nr = r + dr[d] * map[r][c]
            val nc = c + dc[d] * map[r][c]
            if (nr in 0 until n && nc in 0 until n) {
                memo[nr][nc] += memo[r][c]
            }
        }
    }

    for (r in 0 until n) {
        for (c in 0 until n) {
            dp(r, c, memo)
        }
    }

    println(memo[n - 1][n - 1])
}