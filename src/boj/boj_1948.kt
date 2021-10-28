package boj_1948

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

var n = 0
var m = 0
lateinit var graph: Array<LinkedList<Pair<Int, Int>>>
lateinit var graphTransposed: Array<LinkedList<Pair<Int, Int>>>
lateinit var maxDistance: IntArray
lateinit var indegree: IntArray
lateinit var visited: BooleanArray
var start = 0
var destination = 0
var count = 0

fun main() {
    init()
    topologicalSort()
    dfs(destination)
    println(maxDistance[destination])
    println(count)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    m = readLine().toInt()
    graph = Array(n) { LinkedList<Pair<Int, Int>>() }
    graphTransposed = Array(n) { LinkedList<Pair<Int, Int>>() }
    indegree = IntArray(n)
    maxDistance = IntArray(n)
    visited = BooleanArray(n)
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            val w = nextToken().toInt()
            graph[u].addLast(Pair(v, w))
            graphTransposed[v].addLast(Pair(u, w))
            indegree[v]++
        }
    }
    with(StringTokenizer(readLine())) {
        start = nextToken().toInt() - 1
        destination = nextToken().toInt() - 1
    }
    close()
}

fun topologicalSort() {
    val queue = LinkedList<Int>().apply { add(start) }
    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        for (road in graph[current]) {
            indegree[road.first]--
            maxDistance[road.first] = max(maxDistance[road.first], maxDistance[current] + road.second)
            if (indegree[road.first] == 0) {
                queue.addLast(road.first)
            }
        }
    }
}

fun dfs(current: Int) {
    if (visited[current]) {
        return
    }

    visited[current] = true
    for (prev in graphTransposed[current]) {
        if (maxDistance[current] == maxDistance[prev.first] + prev.second) {
            dfs(prev.first)
            count++
        }
    }
}