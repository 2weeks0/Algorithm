package boj_10282

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var d = 0
var c = 0
lateinit var graph: Array<LinkedList<Edge>>

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(bufferedReader.readLine().toInt()) {
        init(bufferedReader)
        val distances = dijkstra()
        printAnswer(distances, bufferedWriter)
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    bufferedReader.close()
}

fun init(bufferedReader: BufferedReader) {
    with(StringTokenizer(bufferedReader.readLine())) {
        n = nextToken().toInt()
        d = nextToken().toInt()
        c = nextToken().toInt() - 1
    }
    graph = Array(n) { LinkedList() }
    repeat(d) {
        with(StringTokenizer(bufferedReader.readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            val s = nextToken().toInt()
            graph[b].add(Edge(a, s))
        }
    }
}

fun dijkstra(): IntArray {
    val distances = IntArray(n) { Int.MAX_VALUE }.apply { this[c] = 0 }
    val priorityQueue = PriorityQueue<Int>() { i1, i2 ->
        distances[i1].compareTo(distances[i2])
    }.apply { add(c) }

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

fun printAnswer(distances: IntArray, bufferedWriter: BufferedWriter) {
    with(distances.filter { it != Int.MAX_VALUE }) {
        bufferedWriter.append("${count()} ${maxOrNull()}\n")
    }
}

class Edge(val to: Int, val value: Int)