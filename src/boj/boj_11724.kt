package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var n = 0
private var m = 0
private lateinit var map: Array<MutableList<Int>>
private lateinit var visited: BooleanArray
private var answer = 0

fun main() {
    init()
    for (i in 0 until n) {
        bfs(i)
    }
    println(answer)
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    map = Array(n) { mutableListOf<Int>() }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            map[a].add(b)
            map[b].add(a)
        }
    }
    visited = BooleanArray(n)
    close()
}

private fun bfs(start: Int) {
    if (visited[start]) {
        return
    }

    val queue = LinkedList<Int>().apply {
        addLast(start)
    }
    visited[start] = true

    while (queue.isNotEmpty()) {
        val pos = queue.pollLast()
        for (next in map[pos]) {
            if (!visited[next]) {
                visited[next] = true
                queue.addLast(next)
            }
        }
    }
    answer++
}