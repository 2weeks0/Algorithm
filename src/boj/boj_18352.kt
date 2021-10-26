package boj_18352

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
var k = 0
var x = 0
lateinit var map: Array<LinkedList<Int>>
lateinit var distance: IntArray

fun main() {
    init()
    dijkstra()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        k = nextToken().toInt()
        x = nextToken().toInt() - 1
    }
    map = Array(n) { LinkedList() }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            map[u].addLast(v)
        }
    }
    distance = IntArray(n) { Int.MAX_VALUE }
    close()
}

fun dijkstra() {
    val pq = PriorityQueue<Pair<Int, Int>>() { p1, p2 ->
        p1.second.compareTo(p2.second)
    }.apply { add(Pair(x, 0)) }
    distance[x] = 0

    while (pq.isNotEmpty()) {
        val current = pq.poll()
        for (next in map[current.first]) {
            if (current.second + 1 < distance[next]) {
                distance[next] = current.second + 1
                pq.add(Pair(next, distance[next]))
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    if (distance.contains(k)) {
        for (i in 0 until n) {
            if (distance[i] == k) {
                append("${i + 1}\n")
            }
        }
    } else {
        append("${-1}\n")
    }
    flush()
    close()
}