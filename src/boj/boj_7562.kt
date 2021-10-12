package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.util.*

private val dr = arrayOf(-2, -1, 1, 2, -2, -1, 1, 2)
private val dc = arrayOf(1, 2, 2, 1, -1, -2, -2, -1)
private var n = 0
private lateinit var map: Array<IntArray>
private lateinit var start: Pair<Int, Int>
private lateinit var end: Pair<Int, Int>

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        repeat(readLine().toInt()) {
            init(this)
            bfs()
            println(map[end.first][end.second])
        }
        close()
    }
}

private fun init(bufferedReader: BufferedReader) {
    n = bufferedReader.readLine().toInt()
    map = Array(n) {
        IntArray(n)
    }
    with(StringTokenizer(bufferedReader.readLine())) {
        start = Pair(nextToken().toInt(), nextToken().toInt())
    }
    with(StringTokenizer(bufferedReader.readLine())) {
        end = Pair(nextToken().toInt(), nextToken().toInt())
    }
}

private fun bfs() {
    val queue = LinkedList<Pair<Int, Int>>().apply {
        addLast(start)
    }

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        if (current.first == end.first && current.second == end.second) {
            return
        }
        for (d in 0 until 8) {
            val nr = current.first + dr[d]
            val nc = current.second + dc[d]
            if (nr in 0 until n && nc in 0 until n && map[nr][nc] == 0) {
                map[nr][nc] = map[current.first][current.second] + 1
                queue.add(Pair(nr, nc))
            }
        }
    }
}