package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.properties.Delegates

private val dr = arrayOf(0, 0, -1, 1)
private val dc = arrayOf(1, -1, 0, 0)
private var r by Delegates.notNull<Int>()
private var c by Delegates.notNull<Int>()
private lateinit var map: Array<String>
private lateinit var visited: BooleanArray
private var answer = 1

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        r = nextToken().toInt()
        c = nextToken().toInt()
    }
    map = Array(r) { readLine() }
    visited = BooleanArray(26).apply {
        this[map[0][0] - 'A'] = true
    }

    bt(1, 0, 0)

    println(answer)
    close()
}

private fun bt(depth: Int, curR: Int, curC: Int) {
    answer = max(answer, depth)
    for (d in 0 until 4) {
        val nr = curR + dr[d]
        val nc = curC + dc[d]
        if (nr in 0 until r && nc in 0 until c) {
            val visitedIndex = map[nr][nc] - 'A'
            if (!visited[visitedIndex]) {
                visited[visitedIndex] = true
                bt(depth + 1, nr, nc)
                visited[visitedIndex] = false
            }
        }
    }
}
