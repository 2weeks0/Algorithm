package boj_9370

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

var n = 0
var m = 0
var t = 0
var s = 0
var g = 0
var h = 0
lateinit var graph: Array<LinkedList<Edge>>
val candidates = ArrayList<Int>()
val answer = ArrayList<Int>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()) {
        init(this)
        val distances = dijkstra()
        candidates.forEach { d ->
            if (distances[d] % 2 != 0) {
                answer.add(d)
            }
        }
        printAnswer(bufferedWriter)
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

fun init(bufferedReader: BufferedReader) {
    answer.clear()
    candidates.clear()
    with(StringTokenizer(bufferedReader.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        t = nextToken().toInt()
    }
    graph = Array(n) { LinkedList() }
    with(StringTokenizer(bufferedReader.readLine())) {
        s = nextToken().toInt() - 1
        g = nextToken().toInt() - 1
        h = nextToken().toInt() - 1
    }
    repeat(m) {
        with(StringTokenizer(bufferedReader.readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            var w = nextToken().toInt()
            if ((a == g && b == h) || (a == h && b == g)) {
                w = 2 * w - 1
            } else {
                w *= 2
            }
            graph[a].add(Edge(b, w))
            graph[b].add(Edge(a, w))
        }
    }
    repeat(t) {
        candidates.add(bufferedReader.readLine().toInt() - 1)
    }
}

fun dijkstra(): IntArray {
    val distances = IntArray(n) { Int.MAX_VALUE - 1 }.apply { this[s] = 0 }
    val priorityQueue = PriorityQueue<Int>() { i1, i2 ->
        distances[i1].compareTo(distances[i2])
    }.apply { add(s) }

    while (priorityQueue.isNotEmpty()) {
        val current = priorityQueue.poll()
        for (edge in graph[current]) {
            if (distances[current] + edge.value < distances[edge.to]) {
                distances[edge.to] = distances[current] + edge.value
                priorityQueue.add(edge.to)
            }
        }
    }

    return distances
}

fun printAnswer(bufferedWriter: BufferedWriter) {
    answer.sort()
    answer.forEach {
        bufferedWriter.append("${it + 1} ")
    }
    bufferedWriter.newLine()
}

class Edge(val to: Int, val value: Int)