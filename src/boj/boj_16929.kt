package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dr = arrayOf(0, 0, 1, -1)
private val dc = arrayOf(1, -1, 0, 0)
private var n = 0
private var m = 0
private lateinit var map: Array<String>
private lateinit var visited: Array<BooleanArray>
private var success = false

fun main() {
    init()
    loop@ for (r in 0 until n) {
        for (c in 0 until m) {
            if (success) {
                break@loop
            }
            visited[r][c] = true
            with(Pair(r, c)) {
                dfs(0, this, this)
            }
            visited[r][c] = false
        }
    }
    println((if (success) "Yes" else "No"))
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    map = Array(n) { readLine() }
    visited = Array(n) { BooleanArray(m) }
    close()
}

private fun dfs(depth: Int, start: Pair<Int, Int>, next: Pair<Int, Int>) {
    if (3 <= depth && start.first == next.first && start.second == next.second) {
        success = true
        return
    }

    for (d in 0 until 4) {
        val nr = next.first + dr[d]
        val nc = next.second + dc[d]
        if (!success && nr in 0 until n && nc in 0 until m && map[nr][nc] == map[start.first][start.second] && (!visited[nr][nc] || (3 <= depth && nr == start.first && nc == start.second))) {
            visited[nr][nc] = true
            dfs(depth + 1, start, Pair(nr, nc))
            visited[nr][nc] = false
        }
    }
}