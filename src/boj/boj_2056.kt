package boj_2056

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

var n = 0
lateinit var costs: IntArray
lateinit var graph: Array<LinkedList<Int>>
lateinit var indegree: IntArray
lateinit var costTaken: IntArray

fun main() {
    init()
    topologicalSort()
    println(costTaken.maxOrNull())
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    costs = IntArray(n)
    graph = Array(n) { LinkedList<Int>() }
    indegree = IntArray(n)
    costTaken = IntArray(n)
    repeat(n) {
        with(StringTokenizer(readLine())) {
            costs[it] = nextToken().toInt()
            val cnt = nextToken().toInt()
            indegree[it] = cnt
            repeat(cnt) { _ ->
                graph[nextToken().toInt() - 1].addLast(it)
            }
        }
    }
    close()
}

fun topologicalSort() {
    val queue = LinkedList<Int>()
    for (i in 0 until n) {
        if (indegree[i] == 0) {
            queue.addLast(i)
            costTaken[i] = costs[i]
        }
    }

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        for (next in graph[current]) {
            costTaken[next] = max(costTaken[next], costs[next] + costTaken[current])
            indegree[next]--
            if (indegree[next] == 0) {
                queue.addLast(next)
            }
        }
    }
}