package boj_1766

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
lateinit var graph: Array<LinkedList<Int>>
lateinit var indegree: IntArray

fun main() {
    init()
    traverse()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    graph = Array(n) { LinkedList<Int>() }
    indegree = IntArray(n)
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            graph[u].addLast(v)
            indegree[v]++
        }
    }
    close()
}

fun traverse() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    val pq = PriorityQueue<Int>() { i1, i2 ->
        i1.compareTo(i2)
    }
    for (i in 0 until n) {
        if (indegree[i] == 0) {
            pq.add(i)
        }
    }

    while (pq.isNotEmpty()) {
        val current = pq.poll()
        append("${current + 1} ")
        for (next in graph[current]) {
            indegree[next]--
            if (indegree[next] == 0) {
                pq.add(next)
            }
        }
    }

    flush()
    close()
}
