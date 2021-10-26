package boj_2150

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

var v = 0
var e = 0
lateinit var map: Array<LinkedList<Int>>
lateinit var mapReversed: Array<LinkedList<Int>>
val answer = ArrayList<ArrayList<Int>>()

fun main() {
    init()
    kosaraju()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        v = nextToken().toInt()
        e = nextToken().toInt()
    }
    map = Array(v) { LinkedList() }
    mapReversed = Array(v) { LinkedList() }
    repeat(e) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            map[a].addLast(b)
            mapReversed[b].addLast(a)
        }
    }
    close()
}

fun kosaraju() {
    val visited = BooleanArray(v)
    val postOrder = LinkedList<Int>()
    for (start in 0 until v) {
        dfs(current = start, postOrder = postOrder, map = map, visited = visited)
    }

    visited.fill(false)
    while (postOrder.isNotEmpty()) {
        val start = postOrder.pollLast()
        if (visited[start]) {
            continue
        }
        answer.add(ArrayList())
        dfs(current = start, order = answer.last(), map = mapReversed, visited = visited)
    }
}

fun dfs(
    current: Int,
    order: ArrayList<Int>? = null,
    postOrder: LinkedList<Int>? = null,
    map: Array<LinkedList<Int>>,
    visited: BooleanArray
) {
    if (visited[current]) {
        return
    }

    visited[current] = true
    order?.add(current)
    for (next in map[current]) {
        if (!visited[next]) {
            dfs(next, order, postOrder, map, visited)
        }
    }
    postOrder?.addLast(current)
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    append("${answer.size}\n")
    answer.forEach { it.sort() }
    answer.sortedWith { l1, l2 -> l1.first().compareTo(l2.first()) }.forEach {
        it.forEach { i ->
            append("${i + 1} ")
        }
        append("-1\n")
    }
    flush()
    close()
}