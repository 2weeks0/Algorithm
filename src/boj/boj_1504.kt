package boj_1504

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var n = 0
var e = 0
lateinit var map: Array<LinkedList<Pair<Int, Int>>>
var v1 = 0
var v2 = 0

fun main() {
    init()
    val distance1 = getDistance(arrayOf(0, v1, v2, n - 1))
    val distance2 = getDistance(arrayOf(0, v2, v1, n - 1))
    if (distance1 == Int.MAX_VALUE && distance1 == distance2) {
        println(-1)
    } else {
        println(min(distance1, distance2))
    }
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        e = nextToken().toInt()
    }
    map = Array(n) { LinkedList<Pair<Int, Int>>() }
    repeat(e) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            val w = nextToken().toInt()
            map[u].addLast(Pair(v, w))
            map[v].addLast(Pair(u, w))
        }
    }
    with(StringTokenizer(readLine())) {
        v1 = nextToken().toInt() - 1
        v2 = nextToken().toInt() - 1
    }
    close()
}

fun dijkstra(start: Int, destination: Int): Int {
    val priorityQueue = PriorityQueue<Pair<Int, Int>>() { n1, n2 ->
        n1.second.compareTo(n2.second)
    }.apply { add(Pair(start, 0)) }
    val distance = IntArray(n) { Int.MAX_VALUE }.apply { this[start] = 0 }

    while (priorityQueue.isNotEmpty()) {
        val current = priorityQueue.poll()
        if (current.first == destination) {
            return distance[current.first]
        }

        for (next in map[current.first]) {
            if (current.second + next.second < distance[next.first]) {
                distance[next.first] = current.second + next.second
                priorityQueue.add(Pair(next.first, distance[next.first]))
            }
        }
    }
    return -1
}

fun getDistance(candidate: Array<Int>): Int {
    var result = 0
    for (i in 0 until candidate.size - 1) {
        val temp = dijkstra(candidate[i], candidate[i + 1])
        if (temp < 0) {
            return Int.MAX_VALUE
        } else {
            result += temp
        }
    }
    return result
}