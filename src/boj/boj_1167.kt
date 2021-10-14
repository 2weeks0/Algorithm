package boj_1167

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
lateinit var map: Array<LinkedList<Pair<Int, Int>>>
lateinit var visited: BooleanArray
var answer = 0
var next = 0

fun main() {
    init()
    visited[0] = true
    dfs(0, 0)
    visited.fill(false)
    visited[next] = true
    dfs(next, 0)
    println(answer)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    map = Array(n) { LinkedList<Pair<Int, Int>>() }
    repeat(n) {
        with(StringTokenizer(readLine())) {
            val start = nextToken().toInt() - 1
            var end = nextToken().toInt() - 1
            while (end != -2) {
                val length = nextToken().toInt()
                map[start].addLast(Pair(end, length))
                end = nextToken().toInt() - 1
            }
        }
    }
    visited = BooleanArray(n)
    close()
}

fun dfs(current: Int, length: Int) {
    if (answer < length) {
        answer = length
        next = current
    }

    for (next in map[current]) {
        if (!visited[next.first]) {
            visited[next.first] = true
            dfs(next.first, length + next.second)
        }
    }
}