package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

private val dr = arrayOf(0, 0, 1, -1)
private val dc = arrayOf(1, -1, 0, 0)
private var n = 0
private var m = 0
private lateinit var map: Array<Array<IntArray>>

fun main() {
    init()
    bfs()

    var answer = 0
    for (i in 0 until 2) {
        answer = if (map[i][n - 1][m - 1] == 0) {
            continue
        } else if (answer == 0) {
            map[i][n - 1][m - 1]
        } else {
            min(answer, map[i][n - 1][m - 1])
        }
    }
    println(if (answer == 0) -1 else answer)
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    val temp = Array(n) { _ ->
        with(readLine()) {
            IntArray(m) {
                when (val input = this[it]) {
                    '1' -> -1
                    else -> input - '0'
                }
            }
        }
    }
    map = Array(2) { Array(n) { IntArray(m) } }
    for (r in 0 until n) {
        for (c in 0 until m) {
            map[0][r][c] = temp[r][c]
            map[1][r][c] = temp[r][c]
        }
    }
    close()
}

private fun bfs() {
    map[0][0][0] = 1
    map[1][0][0] = 1
    val queue = LinkedList<Point>().apply {
        addLast(Point(0, 0, false))
    }

    while (queue.isNotEmpty()) {
        val cr = queue.peekFirst().r
        val cc = queue.peekFirst().c
        val use = queue.pollFirst().use
        for (d in 0 until 4) {
            val nr = cr + dr[d]
            val nc = cc + dc[d]
            if (nr in 0 until n && nc in 0 until m) {
                if (use) {
                    if (map[1][nr][nc] == 0 && map[0][nr][nc] == 0) {
                        map[1][nr][nc] = map[1][cr][cc] + 1
                        queue.addLast(Point(nr, nc, use))
                    }
                } else {
                    if (map[0][nr][nc] == -1) {
                        map[1][nr][nc] = map[0][cr][cc] + 1
                        queue.addLast(Point(nr, nc, true))
                    } else if (map[0][nr][nc] == 0) {
                        map[0][nr][nc] = map[0][cr][cc] + 1
                        queue.addLast(Point(nr, nc, false))
                    }
                }
            }
        }
    }
}

class Point(val r: Int, val c: Int, val use: Boolean)