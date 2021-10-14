package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var n = 0
private lateinit var map: Array<LinkedList<Int>>
private lateinit var input: IntArray
private lateinit var visited: BooleanArray

fun main() {
    init()
    println(bfs())
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    map = Array(n) {
        LinkedList<Int>()
    }
    repeat(n - 1) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            map[a].addLast(b)
            map[b].addLast(a)
        }
    }
    input = with(StringTokenizer(readLine())) {
        IntArray(n) {
            nextToken().toInt() - 1
        }
    }
    visited = BooleanArray(n)
    close()
}

private fun bfs(): Int {
    visited[0] = true
    val queue = LinkedList<Int>().apply {
        addLast(0)
    }
    val set = hashSetOf<Int>().apply {
        add(0)
    }

    var index = set.size

    while (queue.isNotEmpty()) {
        set.clear()
        val current = queue.pollFirst()
        for (next in map[current]) {
            if (!visited[next]) {
                visited[next] = true
                set.add(next)
            }
        }

        for (i in 0 until set.size) {
            if (set.contains(input[index + i])) {
                queue.addLast(input[index + i])
            } else {
                return 0
            }
        }
        index += set.size
    }
    return 1
}