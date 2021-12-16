package boj_1516

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
lateinit var costs: IntArray
lateinit var graph: Array<LinkedList<Int>>
lateinit var indegree: IntArray
lateinit var costTaken: Array<LinkedList<Int>>

fun main() {
    init()
    topologicalSorting()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    costs = IntArray(n)
    graph = Array(n) { LinkedList<Int>() }
    indegree = IntArray(n)
    costTaken = Array(n) { LinkedList<Int>() }
    repeat(n) {
        with(StringTokenizer(readLine())) {
            costs[it] = nextToken().toInt()
            var prev = nextToken().toInt()
            while (prev != -1) {
                indegree[it]++
                graph[prev - 1].addLast(it)
                prev = nextToken().toInt()
            }
        }
    }
    close()
}

fun topologicalSorting() {
    val queue = LinkedList<Int>()
    for (i in 0 until n) {
        if (indegree[i] == 0) {
            queue.addLast(i)
            costTaken[i].addLast(costs[i])
        }
    }

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        for (next in graph[current]) {
            indegree[next]--
            costTaken[next].addLast(costs[next] + (costTaken[current].maxOrNull() ?: 0))
            if (indegree[next] == 0) {
                queue.addLast(next)
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    for (i in 0 until n) {
        append("${costTaken[i].maxOrNull()!!}\n")
    }
    flush()
    close()
}
