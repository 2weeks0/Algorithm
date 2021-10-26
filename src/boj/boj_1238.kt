package boj_1238

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

var n = 0
var m = 0
var x = 0
lateinit var map: Array<LinkedList<Pair<Int, Int>>>

fun main() {
    init()
    val distance = IntArray(n) {
        dijkstra(it, x) + dijkstra(x, it)
    }
    var answer = 0
    for (d in distance) {
        answer = max(answer, d)
    }
    println(answer)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        x = nextToken().toInt() - 1
    }
    map = Array(n) { LinkedList<Pair<Int, Int>>() }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            val w = nextToken().toInt()
            map[u].addLast(Pair(v, w))
        }
    }
}

fun dijkstra(start: Int, destination: Int): Int {
    val distance = IntArray(n) { Int.MAX_VALUE }.apply { this[start] = 0 }
    val priorityQueue = PriorityQueue<Pair<Int, Int>>() {
        n1, n2 -> n1.second.compareTo(n2.second)
    }.apply { add(Pair(start, 0)) }

    while (priorityQueue.isNotEmpty()) {
        val current = priorityQueue.poll()
        if (current.first == destination) {
            return distance[current.first]
        }

        for (next in map[current.first]) {
            if (next.second + current.second < distance[next.first]) {
                distance[next.first] = next.second + current.second
                priorityQueue.add(Pair(next.first, distance[next.first]))
            }
        }
    }

    throw Exception()
}