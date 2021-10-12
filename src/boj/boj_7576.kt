package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

private val dx = arrayOf(1, -1, 0, 0)
private val dy = arrayOf(0, 0, 1, -1)
private var m = 0
private var n = 0
private lateinit var map: Array<IntArray>
private val queue = LinkedList<Pair<Int, Int>>()

fun main() {
    init()
    bfs()
    var max = -1
    for (y in 0 until n) {
        for (x in 0 until m) {
            max = max(max, map[y][x])
        }
    }
    println(if (max == n * m) -1 else max)
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        m = nextToken().toInt()
        n = nextToken().toInt()
    }
    map = Array(n) { y ->
        with(StringTokenizer(readLine())) {
            IntArray(m) { x ->
                when (val input = nextToken().toInt()) {
                    0 -> n * m
                    1 -> {
                        queue.add(Pair(x, y))
                        0
                    }
                    else -> input
                }
            }
        }
    }
    close()
}

private fun bfs() {
    while (queue.isNotEmpty()) {
        val c = queue.pollFirst()
        for (d in 0 until 4) {
            val nx = c.first + dx[d]
            val ny = c.second + dy[d]
            if (nx in 0 until m && ny in 0 until n && map[c.second][c.first] + 1 < map[ny][nx]) {
                map[ny][nx] = map[c.second][c.first] + 1
                queue.addLast(Pair(nx, ny))
            }
        }
    }
}