package boj_18290

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

var n = 0
var m = 0
var k = 0
lateinit var map: Array<IntArray>
var answer = Int.MIN_VALUE
val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun main() {
    init()
    val visited = Array(n) { BooleanArray(m) }
    visited[0][0] = true
    backTracking(0, 0, visited, 1)
    visited[0][0] = false
    backTracking(0, 0, visited, 0)
    println(answer)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        k = nextToken().toInt()
    }
    map = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(m) {
                nextToken().toInt()
            }
        }
    }
    close()
}

fun backTracking(cx: Int, cy: Int, visited: Array<BooleanArray>, cnt: Int) {
    if (cnt == k) {
        var sum = 0
        for (y in 0 until n) {
            for (x in 0 until m) {
                if (visited[y][x]) {
                    sum += map[y][x]
                }
            }
        }
        answer = max(answer, sum)
        return
    }

    for (i in cx + cy * m + 1 until n * m) {
        val nx = i % m
        val ny = i / m
        if (canAdd(nx, ny, visited)) {
            visited[ny][nx] = true
            backTracking(nx, ny, visited, cnt + 1)
            visited[ny][nx] = false
        }
    }
}

fun canAdd(x: Int, y: Int, visited: Array<BooleanArray>): Boolean {
    for (d in 0 until 4) {
        val nx = x + dx[d]
        val ny = y + dy[d]
        if (nx in 0 until m && ny in 0 until n && visited[ny][nx]) {
            return false
        }
    }
    return true
}