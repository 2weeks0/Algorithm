package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

private val dr = arrayOf(0, 0, 1, -1)
private val dc = arrayOf(1, -1, 0, 0)
private var n = 0
private var m = 0
private lateinit var map: Array<IntArray>

fun main() {
    init()
    println(bfs())
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        m = nextToken().toInt()
        n = nextToken().toInt()
    }
    map = Array(n) {
        with(readLine()) {
            IntArray(m) {
                this[it] - '0'
            }
        }
    }
    close()
}

private fun bfs(): Int {
    val cnt = Array(n) { IntArray(m) { n * m } }.apply {
        this[0][0] = 0
    }
    val queue = LinkedList<Pair<Int, Int>>().apply {
        addLast(Pair(0, 0))
    }

    while (queue.isNotEmpty()) {
        val pos = queue.pollFirst()
        for (d in 0 until 4) {
            val nr = pos.first + dr[d]
            val nc = pos.second + dc[d]
            if (nr in 0 until n && nc in 0 until m) {
                val temp = min(cnt[nr][nc], cnt[pos.first][pos.second] + map[nr][nc])
                if (temp < cnt[nr][nc]) {
                    cnt[nr][nc] = temp
                    queue.addLast(Pair(nr, nc))
                }
            }
        }
    }
    return cnt[n - 1][m - 1]
}