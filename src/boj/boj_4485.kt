package boj_4485

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
lateinit var map: Array<IntArray>

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    var num = 1
    while (init(bufferedReader)) {
        bufferedWriter.append("Problem ${num++}: ${dijkstra()}\n")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    bufferedReader.close()
}

fun init(bufferedReader: BufferedReader): Boolean {
    n = bufferedReader.readLine().toInt()
    if (n == 0) {
        return false
    }

    map = Array(n) {
        with(StringTokenizer(bufferedReader.readLine())) {
            IntArray(n) {
                nextToken().toInt()
            }
        }
    }
    return true
}

fun dijkstra(): Int {
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)
    val priorityQueue = PriorityQueue<Candidate>() { c1, c2 ->
        c1.compare(c2)
    }.apply { add(Candidate(0, 0, map[0][0])) }
    val distance = Array(n) { IntArray(n) { Int.MAX_VALUE } }.apply { this[0][0] = map[0][0] }

    while (priorityQueue.isNotEmpty()) {
        val candidate = priorityQueue.poll();
        if (candidate.x == n - 1 && candidate.y == n - 1) {
            return distance[n - 1][n - 1]
        }

        for (d in 0 until 4) {
            val nx = candidate.x + dx[d]
            val ny = candidate.y + dy[d]
            if (nx in 0 until n && ny in 0 until n && map[ny][nx] + candidate.distance < distance[ny][nx]) {
                distance[ny][nx] = candidate.distance + map[ny][nx]
                priorityQueue.add(Candidate(nx, ny, distance[ny][nx]))
            }
        }
    }
    return -1
}

class Candidate(val x: Int, val y: Int, val distance: Int) {
    fun compare(other: Candidate) = distance.compareTo(other.distance)
}