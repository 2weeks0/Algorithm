package boj_2252

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
lateinit var graph: Array<LinkedList<Int>>
lateinit var open: BooleanArray
lateinit var visited: BooleanArray
val postOrder = LinkedList<Int>()

fun main() {
    init()
    for (i in 0 until n) {
        if (open[i]) {
            dfs(i)
        }
    }
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    graph = Array(n) { LinkedList() }
    open = BooleanArray(n) { true }
    visited = BooleanArray(n)
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            graph[a].addLast(b)
            open[b] = false
        }
    }
    close()
}

fun dfs(current: Int) {
    for (next in graph[current]) {
        if (!visited[next]) {
            visited[next] = true
            dfs(next)
        }
    }
    postOrder.addLast(current)
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    while (postOrder.isNotEmpty()) {
        append("${postOrder.pollLast() + 1} ")
    }
    flush()
    close()
}