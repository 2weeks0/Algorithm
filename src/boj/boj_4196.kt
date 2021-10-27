package boj_4196

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
lateinit var map: Array<LinkedList<Int>>
lateinit var mapReversed: Array<LinkedList<Int>>
lateinit var visited: BooleanArray
val scc = LinkedList<Int>()
var answer = 0

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val t = bufferedReader.readLine().toInt()
    repeat(t) {
        init(bufferedReader)
        kosaraju()
        dfsWithScc()
        bufferedWriter.append("$answer\n")
    }
    bufferedReader.close()
    bufferedWriter.let {
        it.flush()
        it.close()
    }
}

fun init(bufferedReader: BufferedReader) {
    with(StringTokenizer(bufferedReader.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    map = Array(n) { LinkedList() }
    mapReversed = Array(n) { LinkedList() }
    visited = BooleanArray(n)
    repeat(m) {
        with(StringTokenizer(bufferedReader.readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            map[u].addLast(v)
            mapReversed[v].addLast(u)
        }
    }
}

fun kosaraju() {
    val postOrder = LinkedList<Int>()
    visited.fill(false)
    for (i in 0 until n) {
        dfs(i, postOrder, map)
    }

    visited.fill(false)
    while (postOrder.isNotEmpty()) {
        val current = postOrder.pollLast()
        if (visited[current]) {
            continue
        }
        scc.addLast(current)
        dfs(current, null, mapReversed)
    }
}

fun dfs(current: Int, postOrder: LinkedList<Int>?, map: Array<LinkedList<Int>>) {
    if (visited[current]) {
        return
    }

    visited[current] = true
    for (next in map[current]) {
        if (!visited[next]) {
            dfs(next, postOrder, map)
        }
    }
    postOrder?.addLast(current)
}

fun dfsWithScc() {
    answer = 0
    visited.fill(false)
    while (scc.isNotEmpty()) {
        val current = scc.pollFirst()
        if (visited[current]) {
            continue
        }
        answer++
        dfs(current, null, map)
    }
}