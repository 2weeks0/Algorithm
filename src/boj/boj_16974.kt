package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private var n = 0
private lateinit var map: Array<LinkedList<Int>>
private lateinit var cycle: BooleanArray
private lateinit var answer: IntArray
private var findCycle = false

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    loop@for (i in map.indices) {
        if (2 == map[i].size) {
            cycle[i] = true
            dfs(0, i, i)
            if (findCycle) {
                break@loop
            }
            cycle[i] = false
        }
    }

    for (i in map.indices) {
        if (3 <= map[i].size && cycle[i]) {
            bfs(i)
        }
    }

    answer.forEach {
        append("$it ")
    }
    flush()
    close()
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    map = Array(n) { LinkedList<Int>() }
    repeat(n) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            map[a].addLast(b)
            map[b].addLast(a)
        }
    }
    cycle = BooleanArray(n)
    answer = IntArray(n)
    close()
}

private fun dfs(depth: Int, start: Int, current: Int) {
    if (3 <= depth && start == current) {
        findCycle = true
        return
    }

    for (next in map[current]) {
        if (!findCycle && (!cycle[next] || (3 <= depth + 1 && start == next))) {
            cycle[next] = true
            dfs(depth + 1, start, next)
            if (!findCycle) {
                cycle[next] = false
            }
        }
    }
}

private fun bfs(start: Int) {
    val queue = LinkedList<Int>().apply {
        addLast(start)
    }

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        for (next in map[current]) {
            if (!cycle[next] && answer[next] == 0) {
                answer[next] = answer[current] + 1
                queue.addLast(next)
            }
        }
    }
}