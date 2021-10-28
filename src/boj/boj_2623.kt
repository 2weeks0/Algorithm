package boj_2623

import java.io.*
import java.util.*

var n = 0
var m = 0
lateinit var graph: Array<LinkedList<Int>>
lateinit var indegree: IntArray
val answer = LinkedList<Int>()

fun main() {
    init()
    topologicalSort()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    graph = Array(n) { LinkedList<Int>() }
    indegree = IntArray(n)
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val cnt = nextToken().toInt()
            var prev = nextToken().toInt() - 1
            repeat(cnt - 1) {
                val next = nextToken().toInt() - 1
                graph[prev].addLast(next)
                indegree[next]++
                prev = next
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
        }
    }

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        answer.addLast(current)
        for (next in graph[current]) {
            indegree[next]--
            if (indegree[next] == 0) {
                queue.addLast(next)
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    if (answer.size != n) {
        append('0')
    } else {
        while (answer.isNotEmpty()) {
            append("${answer.pollFirst() + 1}\n")
        }
    }
    flush()
    close()
}