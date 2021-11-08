package boj_11048

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

val dr = arrayOf(-1, 0, -1)
val dc = arrayOf(0, -1, -1)
var n = 0
var m = 0
lateinit var graph: Array<IntArray>

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    graph = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(m) {
                nextToken().toInt()
            }
        }
    }
    close()
}

fun solve() {
    val memo = Array(n) { IntArray(m) }.apply { this[0][0] = graph[0][0] }
    fun dp(r : Int, c: Int, memo: Array<IntArray>) {
        var temp = 0
        for (i in 0 until 3) {
            val prevR = r + dr[i]
            val prevC = c + dc[i]
            if (prevR in 0 until n && prevC in 0 until m) {
                temp = max(temp, memo[prevR][prevC])
            }
        }
        memo[r][c] = graph[r][c] + temp
    }

    for (r in 0 until n) {
        for (c in 0 until m) {
            dp(r, c, memo)
        }
    }

    println(memo[n - 1][m - 1])
}