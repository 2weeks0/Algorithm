package boj_1916

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var m = 0
lateinit var buses: Array<LinkedList<Pair<Int, Int>>>
lateinit var distance: IntArray
var start = 0
var destination = 0

fun main() {
    init()
    dijkstra()
    println(distance[destination])
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    buses = Array(n) { LinkedList<Pair<Int, Int>>() }
    distance = IntArray(n) { Int.MAX_VALUE }
    m = readLine().toInt()
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            val w = nextToken().toInt()
            buses[u].add(Pair(v, w))
        }
    }
    with(StringTokenizer(readLine())) {
        start = nextToken().toInt() - 1
        destination = nextToken().toInt() - 1
    }
    close()
}

fun dijkstra() {
    val priorityQueue = PriorityQueue<Pair<Int, Int>>() { n1, n2 ->
        n1.second.compareTo(n2.second)
    }.apply { add(Pair(start, 0)) }
    distance[start] = 0

    while (priorityQueue.isNotEmpty()) {
        val current = priorityQueue.poll()
        if (current.first == destination) {
            return
        }

        for (next in buses[current.first]) {
            if (current.second + next.second < distance[next.first]) {
                distance[next.first] = current.second + next.second
                priorityQueue.add(Pair(next.first, distance[next.first]))
            }
        }
    }
}

