package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dr = arrayOf(0, 0, 1, -1)
private val dc = arrayOf(1, -1, 0, 0)
private var r = 0
private var c = 0
private lateinit var map: Array<IntArray>
private lateinit var finish: Pair<Int, Int>
private val queueS = LinkedList<Pair<Int, Int>>()
private val queueW = LinkedList<Pair<Int, Int>>()

fun main() {
    init()
    bfs()
    val answer = map[finish.first][finish.second]
    println(if (answer == 0) "KAKTUS" else answer)
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        r = nextToken().toInt()
        c = nextToken().toInt()
    }
    map = Array(r) { dr ->
        with(readLine()) {
            IntArray(c) { dc ->
                when (this[dc]) {
                    'S' -> {
                        queueS.addLast(Pair(dr, dc))
                        0
                    }
                    '*' -> {
                        queueW.addLast(Pair(dr, dc))
                        0
                    }
                    'D' -> {
                        finish = Pair(dr, dc)
                        -1
                    }
                    'X' -> -1
                    else -> 0
                }
            }
        }
    }
    close()
}

private fun bfs() {
    while (queueW.isNotEmpty()) {
        val p = queueW.pollFirst()
        for (d in 0 until 4) {
            val nr = p.first + dr[d]
            val nc = p.second + dc[d]
            if (nr in 0 until r && nc in 0 until c && (map[nr][nc] == 0 || map[p.first][p.second] + 1 < map[nr][nc])) {
                map[nr][nc] = map[p.first][p.second] + 1
                queueW.addLast(Pair(nr, nc))
            }
        }
    }
    with(queueS.peekFirst()) {
        map[first][second] = 0
    }
    map[finish.first][finish.second] = 0
    while (queueS.isNotEmpty()) {
        val p = queueS.pollFirst()
        for (d in 0 until 4) {
            val nr = p.first + dr[d]
            val nc = p.second + dc[d]
            if (nr in 0 until r && nc in 0 until c && (map[nr][nc] == 0 || map[p.first][p.second] + 1 < map[nr][nc])) {
                map[nr][nc] = map[p.first][p.second] + 1
                queueS.addLast(Pair(nr, nc))
            }
        }
    }
}
