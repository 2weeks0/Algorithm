package boj_1753

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var v = 0
var e = 0
var start = 0
lateinit var map: Array<LinkedList<Pair<Int, Int>>>
lateinit var distance: IntArray

fun main() {
    init()
    dijkstra()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        v = nextToken().toInt()
        e = nextToken().toInt()
    }
    start = readLine().toInt() - 1
    map = Array(v) { LinkedList<Pair<Int, Int>>() }
    repeat(e) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            val w = nextToken().toInt()
            map[u].addLast(Pair(v, w))
        }
    }
    distance = IntArray(v) { Int.MAX_VALUE }
    close()
}

fun dijkstra() {
    val priorityQueue = PriorityQueue<Pair<Int, Int>>() {
        n1, n2 -> n1.second.compareTo(n2.second)
    }.apply { add(Pair(start, 0)) }
    distance[start] = 0

    while (priorityQueue.isNotEmpty()) {
        val current = priorityQueue.poll()

        for (next in map[current.first]) {
            if (current.second + next.second < distance[next.first]) {
                distance[next.first] = current.second + next.second
                priorityQueue.add(Pair(next.first, distance[next.first]))
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    for (d in distance) {
        if (d == Int.MAX_VALUE) {
            append("INF\n")
        } else {
            append("$d\n")
        }
    }
    flush()
    close()
}