package boj_2637

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
lateinit var graph: Array<LinkedList<Pair<Int, Int>>>
lateinit var indegree: IntArray
lateinit var isBasicParts: BooleanArray
lateinit var counts: IntArray

fun main() {
    init()
    topologicalSort()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    m = readLine().toInt()
    graph = Array(n) { LinkedList<Pair<Int, Int>>() }
    indegree = IntArray(n)
    isBasicParts = BooleanArray(n) { true }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            val w = nextToken().toInt()
            graph[u].add(Pair(v, w))
            isBasicParts[u] = false
            indegree[v]++
        }
    }
    counts = IntArray(n)
    close()
}

fun topologicalSort() {
    val queue = LinkedList<Int>()
    for (i in 0 until n) {
        if (indegree[i] == 0) {
            queue.addLast(i)
            counts[i] = 1
        }
    }

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        for (next in graph[current]) {
            indegree[next.first]--
            counts[next.first] += next.second * counts[current]
            if (indegree[next.first] == 0) {
                queue.addLast(next.first)
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    for (i in 0 until n) {
        if (isBasicParts[i]) {
            append("${i + 1} ${counts[i]}\n")
        }
    }
    flush()
    close()
}