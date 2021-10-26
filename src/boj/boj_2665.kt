package boj_2665

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
lateinit var map: Array<BooleanArray>
lateinit var cost: Array<IntArray>

fun main() {
    init()
    dijkstra()
    println(cost[n - 1][n - 1])
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    map = Array(n) {
        with(readLine()) {
            BooleanArray(n) {
                this[it] == '1'
            }
        }
    }
    cost = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    close()
}

fun dijkstra() {
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)
    val priorityQueue = PriorityQueue<Point>() { p1, p2 ->
        p1.compare(p2)
    }.apply { add(Point(0, 0, 0)) }
    cost[0][0] = 0

    while (priorityQueue.isNotEmpty()) {
        val current = priorityQueue.poll()
        if (current.x == n - 1 && current.y == n - 1) {
            return
        }
        for (d in 0 until 4) {
            val nx = current.x + dx[d]
            val ny = current.y + dy[d]
            if (nx in 0 until n && ny in 0 until n) {
                val temp = if (map[ny][nx]) 0 else 1
                if (temp + current.cost < cost[ny][nx]) {
                    cost[ny][nx] = temp + current.cost
                    priorityQueue.add(Point(nx, ny, cost[ny][nx]))
                }
            }
        }
    }
}

class Point(val x: Int, val y: Int, val cost: Int) {
    fun compare(other: Point) = cost.compareTo(other.cost)
}