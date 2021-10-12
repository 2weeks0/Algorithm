package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var n = 0
private var m = 0
private lateinit var map: Array<MutableList<Int>>
private lateinit var visited: BooleanArray
private var success = false

fun main() {
    init()
    for (i in 0 until n) {
        visited.fill(false)
        visited[i] = true
        success = false
        dfs(0, i)
        if (success) {
            println(1)
            return
        }
    }
    println(0)
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    map = Array(n) { mutableListOf<Int>() }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            map[a].add(b)
            map[b].add(a)
        }
    }
    visited = BooleanArray(n)
}

private fun dfs(depth: Int, start: Int) {
    if (depth == 4) {
        success = true
        return
    }

    for (next in map[start]) {
        if (!visited[next]) {
            visited[next] = true
            dfs(depth + 1, next)
            visited[next] = false
        }
    }
}
